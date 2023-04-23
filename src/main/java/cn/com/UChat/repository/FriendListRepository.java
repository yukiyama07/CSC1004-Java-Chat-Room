package cn.com.UChat.repository;

import cn.com.UChat.entity.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// Friend list repository
public interface FriendListRepository extends JpaRepository<FriendList, Long> {

    // Check if the two users are friends
    String isFriendStr = "SELECT COUNT(1) FROM uchat_friend_list WHERE (friend_user_id=?1 AND user_id=?2" +
            "OR (friend_user_id=?2 AND user_id=?1)";
    @Query(value = isFriendStr, nativeQuery = true)
    int isFriend(Long sendUserId, Long receiveUserId);

    // Get friend list
    String selectAllFriendByUserIdStr = "SELECT\n" +
            "    `uchat_user`.`id`\n" +
            "    , `uchat_user`.`avatar`\n" +
            "    , `uchat_user`.`is_online`\n" +
            "    , `uchat_user`.`password`\n" +
            "    , `uchat_user`.`username`\n" +
            "    , `uchat_friend_list`.`friend_nick_name`\n" +
            "FROM\n" +
            "    `db_uchat`.`uchat_friend_list`\n" +
            "    INNER JOIN `db_uchat`.`uchat_user` \n" +
            "        ON (`uchat_friend_list`.`friend_user_id` = `uchat_user`.`id`)\n" +
            "WHERE uchat_friend_list.user_id = ?1";
    @Query(value = selectAllFriendByUserIdStr, nativeQuery = true)
    List<Object[]> selectAllFriendByUserId(Long userId);

    // Get un-friend list
    String selectAllUnFriendByUserIdStr = "SELECT " +
            "    `uchat_user`.`id`\n" +
            "    , `uchat_user`.`avatar`\n" +
            "    , `uchat_user`.`is_online`\n" +
            "    , `uchat_user`.`password`\n" +
            "    , `uchat_user`.`username`\n" + " FROM uchat_user WHERE id NOT IN (SELECT friend_user_id FROM uchat_friend_list WHERE user_id=?1) AND id != ?1";
    @Query(value = selectAllUnFriendByUserIdStr, nativeQuery = true)
    List<Object[]> selectAllUnFriendByUserId(Long userId);

}
