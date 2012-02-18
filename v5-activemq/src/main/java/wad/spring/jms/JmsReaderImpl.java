/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.jms;

import javax.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


/**
 *
 * @author tonykovanen
 */
@Service
public class JmsReaderImpl implements JmsReader {
    @Autowired
    JmsTemplate jms;
    
    @Override
    public String read() throws JMSException {
        return jms.receive("the_queue").toString();
    }
    
}
