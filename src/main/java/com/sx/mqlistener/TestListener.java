package com.sx.mqlistener;
import com.alibaba.fastjson.JSONObject;
import com.sx.entity.User;
import lombok.extern.log4j.Log4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
/**
 * moayi
 *
 * @create 2018-05-30 11:24
 **/
@Log4j
@Service(value = "testListener")
public class TestListener implements SessionAwareMessageListener {
    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        try {
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
            String res = msg.getText();
           User user = JSONObject.parseObject(res, User.class);
            log.info("接收到消息=========================================================>"+user.getId());
            msg.acknowledge();
        } catch (JMSException e) {
            session.rollback();
            e.printStackTrace();
        }
    }
}