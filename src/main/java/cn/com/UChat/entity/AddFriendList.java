package cn.com.UChat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

// Add friend list entity
@Entity
@Table(name = "uchat_add_friend_list")
@Data
public class AddFriendList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sendUserId;
    Long receiveUserId;
    String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    Date sendTime;
    Integer isReceive = 0;  // 0: not receive, 1: receive, 2: refuse
}
