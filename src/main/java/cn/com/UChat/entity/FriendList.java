package cn.com.UChat.entity;

import lombok.Data;
import javax.persistence.*;

// Friend list entity
@Entity
@Table(name = "uchat_friend_list")
@Data
public class FriendList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long friendUserId;
    String friendNickName;
}
