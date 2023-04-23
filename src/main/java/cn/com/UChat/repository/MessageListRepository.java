package cn.com.UChat.repository;

import cn.com.UChat.entity.MessageList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// Message list repository
public interface MessageListRepository extends JpaRepository<MessageList, Long>, JpaSpecificationExecutor {
}
