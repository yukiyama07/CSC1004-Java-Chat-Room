package cn.com.UChat.entity;

import lombok.Data;
import javax.persistence.*;

// User entity
@Entity
@Table(name = "uchat_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String avatar;
    Boolean isOnline = false;
}
