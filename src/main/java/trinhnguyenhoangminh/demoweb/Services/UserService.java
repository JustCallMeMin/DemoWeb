package trinhnguyenhoangminh.demoweb.Services;

import trinhnguyenhoangminh.demoweb.Entities.User;
import trinhnguyenhoangminh.demoweb.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        if (!isValid(user.getUsername())) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!isValid(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        if (!isValid(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        return userRepository.findByUsername(username);
    }

    private boolean isValid(String input) {
        return input != null && input.matches("^[a-zA-Z0-9]+$");
    }
}
