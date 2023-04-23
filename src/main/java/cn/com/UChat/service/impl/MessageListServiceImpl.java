package cn.com.UChat.service.impl;

import cn.com.UChat.common.Constant;
import cn.com.UChat.common.ResponseEnum;
import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.MessageList;
import cn.com.UChat.repository.MessageListRepository;
import cn.com.UChat.service.MessageListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

// Message list service implementation
@Slf4j
@Service
public class MessageListServiceImpl implements MessageListService {
    @Autowired
    MessageListRepository messageListRepository;

    // Get the last Eight messages
    @Override
    public ServerResponse getEightMessage(Long sendUserId, Long receiveUserId) {
        try {
            // Create a specification object to define the conditions for the query
            Specification specification = new Specification() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    // Create a list of predicates to define the conditions for the query
                    List<Predicate> predicates = new ArrayList<>();
                    List<Predicate> predicates2 = new ArrayList<>();
                    // Add the conditions for messages sent by the sendUserId and received by the receiveUserId
                    predicates.add(criteriaBuilder.equal(root.get("sendUserId"),sendUserId));
                    predicates.add(criteriaBuilder.equal(root.get("receiveUserId"),receiveUserId));
                    // Add the conditions for messages sent by the receiveUserId and received by the sendUserId
                    predicates2.add(criteriaBuilder.equal(root.get("sendUserId"),receiveUserId));
                    predicates2.add(criteriaBuilder.equal(root.get("receiveUserId"),sendUserId));
                    // Combine the conditions with 'and' operator for each list of predicates and then combine the two lists with 'or' operator
                    Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                    predicate = criteriaBuilder.or(predicate, criteriaBuilder.and(predicates2.toArray(new Predicate[predicates.size()])));
                    return predicate;
                }
            };
            // Create a sort object to define the sorting order of the query results
            Sort orders = Sort.by(Sort.Direction.DESC, "sendTime");
            // Create a MessageList object and set the sendUserId and receiveUserId properties to retrieve the relevant messages
            MessageList messageList = new MessageList();
            messageList.setSendUserId(sendUserId);
            messageList.setReceiveUserId(receiveUserId);
            // Create a page request object to define the page number and size for the query results
            PageRequest pageRequest = PageRequest.of(0, 8, orders);
            // Execute the query and retrieve the results
            Page<MessageList> page = messageListRepository.findAll(specification, pageRequest);
            List<MessageList> messageLists = page.getContent();
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS).data(messageLists);
        }catch (Exception e) {
            e.printStackTrace();
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }

    // Save message
    @Override
    public void saveMessage(MessageList messageList) {
        try {
            // Save the message
            messageListRepository.save(messageList);
        }catch (Exception e) {
            e.printStackTrace();
            log.info(Constant.TAG_YUKI + e.getMessage());
        }
    }
}
