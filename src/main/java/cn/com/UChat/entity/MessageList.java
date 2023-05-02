package cn.com.UChat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

// Add friend list entity
@Entity
@Table(name = "uchat_message_list")
@Data
public class MessageList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sendUserId;
    Long receiveUserId;
    String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    Date sendTime;
}
