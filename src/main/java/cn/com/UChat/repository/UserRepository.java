package cn.com.UChat.repository;

import cn.com.UChat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// User repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Check if the account exists by username
    User findByUsername(String username);

    // Check if the account exists by username and password
    User findByUsernameAndPassword(String username, String password);
}
