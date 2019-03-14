package com.test;

import java.util.Hashtable;

import javax.jms.Session;

import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSession;

public class MQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		sendMsg();
	}

	private static void sendMsg() {
		/*try{
			Hashtable<String, Object> mqht = new Hashtable<String, Object>();
			mqht.put(CMQC.CHANNEL_PROPERTY, "recv");
	         mqht.put(CMQC.HOST_NAME_PROPERTY, "127.0.0.1");

	         try
	         {
	            mqht.put(CMQC.PORT_PROPERTY, new Integer(1414));
	         }
	         catch (NumberFormatException e)
	         {
	            mqht.put(CMQC.PORT_PROPERTY, new Integer(1414));
	         }

	         mqht.put(CMQC.USER_ID_PROPERTY, "CipherCloud");
	         mqht.put(CMQC.PASSWORD_PROPERTY, "retek123");
	         int openOptions = CMQC.MQOO_INPUT_AS_Q_DEF | CMQC.MQOO_OUTPUT + CMQC.MQOO_FAIL_IF_QUIESCING;
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			gmo.options = CMQC.MQGMO_NO_WAIT + CMQC.MQGMO_FAIL_IF_QUIESCING;
			MQQueueManager qMgr = new MQQueueManager("mymanager", mqht);
			com.ibm.mq.MQQueue queue = qMgr.accessQueue("in", openOptions);
		} catch(Exception e){
			e.printStackTrace();
		}*/
	}

}
