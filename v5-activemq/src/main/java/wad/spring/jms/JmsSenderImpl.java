/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.jms;

import javax.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonykovanen
 */
@Service
public class JmsSenderImpl implements JmsSender {
    @Autowired
    JmsTemplate jms;

    @Override
    public void send(final String message) {
        MessageCreator messageCreator = new MessageCreator() {

            @Override
            public javax.jms.Message createMessage(javax.jms.Session sn) throws JMSException {
                return sn.createTextMessage(message);
            }
        };
        jms.send("the_queue", messageCreator);
    }
}
