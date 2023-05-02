package cn.com.UChat.vo;

import lombok.Data;
import java.util.Date;

// Add friend vo
@Data
public class AddFriendVo {
    Integer id;
    Date sendTime;
    String message;
    String avatar;
    String username;
}
