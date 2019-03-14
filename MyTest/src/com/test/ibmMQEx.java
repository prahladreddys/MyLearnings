package com.test;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;

public class ibmMQEx {
    public static void main(String[] args) {
        try {
            /*MQ Configuration*/
            MQQueueConnectionFactory cf = new MQQueueConnectionFactory();
            cf.setHostName("localhost");
            cf.setChannel("recv");//communications link
            cf.setPort(1417);
            cf.setQueueManager("my1");//service provider 
            cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
            
            /*Create Connection */
            QueueConnection connection = cf.createQueueConnection("CipherCloud","retek123");
//            cf.setHostName("localhost");
//            cf.setPort(1414);
//              
//            cf.setMQConnectionOptions(WMQConstants.WMQ_CM_CLIENT);
//            
//            cf.setQueueManager("QM_GRIDSERVER");
//            cf.setChannel("SYSTEM.ADMIN.SVRCONN");
              
//            MQQueueConnection connection = (MQQueueConnection) cf.createQueueConnection();
            connection.start();

            /*Create session */
            QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            /*Create response queue */
            Queue queue = queueSession.createQueue("out");


            /*Create text message */
            TextMessage textMessage = queueSession.createTextMessage("put some message here");
            textMessage.setJMSReplyTo(queue);
            textMessage.setJMSType("mcd://xmlns");//message type
            textMessage.setJMSExpiration(2*1000);//message expiration
            textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT); //message delivery mode either persistent or non-persistemnt

            /*Create sender queue */
            QueueSender queueSender = queueSession.createSender(queueSession.createQueue("in"));
            queueSender.setTimeToLive(2*1000);
            queueSender.send(textMessage);

            /*After sending a message we get message id */
            System.out.println("after sending a message we get message id "+ textMessage.getJMSMessageID());
            String jmsCorrelationID = " JMSCorrelationID = '" + textMessage.getJMSMessageID() + "'";


            /*Within the session we have to create queue reciver */
            QueueReceiver queueReceiver = queueSession.createReceiver(queue,jmsCorrelationID);


            /*Receive the message from*/
            Message message = queueReceiver.receive(60*1000);
            String responseMsg = ((TextMessage) message).getText();

            queueSender.close();
            queueReceiver.close();
            queueSession.close();
            connection.close();


        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
