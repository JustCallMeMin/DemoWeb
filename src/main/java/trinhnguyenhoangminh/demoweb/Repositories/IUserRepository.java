package trinhnguyenhoangminh.demoweb.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trinhnguyenhoangminh.demoweb.Entities.User;

public interface IUserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);
}
