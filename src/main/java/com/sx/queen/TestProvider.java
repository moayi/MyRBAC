package com.sx.queen;

import com.alibaba.fastjson.JSONObject;
import com.sx.entity.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * moayi
 *
 * @create 2018-05-30 11:15
 **/
@Service
@Log4j
public class TestProvider {
    @Autowired
    private JmsTemplate jmsQueueTemplate;
    public void sendMessage(final User user){
        log.info("生产者开始传递消息进入队列....");
        jmsQueueTemplate.send("test",new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(JSONObject.toJSONString(user));
            }
        });
    }
}