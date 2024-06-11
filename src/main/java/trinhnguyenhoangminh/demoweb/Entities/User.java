package trinhnguyenhoangminh.demoweb.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String id = UUID.randomUUID().toString();

    private String username;
    private String password;
}