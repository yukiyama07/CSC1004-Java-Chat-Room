package cn.com.UChat.repository;

import cn.com.UChat.entity.AddFriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// Add friend list repository
public interface AddFriendListRepository extends JpaRepository<AddFriendList, Long> {

    // find by send user id and receive user id and is received
    AddFriendList findBySendUserIdAndReceiveUserIdAndIsReceive(Long sendUserId,Long receiveUserId, Integer isReceive);

    // Select all add friend list by receive user id and is received order by send time
    String selectByReceiveUserIdAndIsReceiveOrderBySendTimeDescStr = "SELECT\n" +
            "    `uchat_user`.`username`\n" +
            "    , `uchat_user`.`avatar`\n" +
            "    , `uchat_add_friend_list`.`message`\n" +
            "    , `uchat_add_friend_list`.`is_receive`\n" +
            "    , `uchat_add_friend_list`.`send_time`\n" +
            "    , `uchat_add_friend_list`.`id`\n" +
            "FROM\n" +
            "    `db_uchat`.`uchat_user`\n" +
            "    INNER JOIN `db_uchat`.`uchat_add_friend_list` \n" +
            "        ON (`uchat_user`.`id` = `uchat_add_friend_list`.`send_user_id`)\n" +
            "WHERE `uchat_add_friend_list`.`receive_user_id` = ?1 AND `uchat_add_friend_list`.`is_receive` IS FALSE \n" +
            "ORDER BY `uchat_add_friend_list`.`send_time` DESC;";
    @Query(value = selectByReceiveUserIdAndIsReceiveOrderBySendTimeDescStr, nativeQuery=true)
    List<Object[]> selectByReceiveUserIdAndIsReceiveOrderBySendTimeDesc(Long userId);
}
