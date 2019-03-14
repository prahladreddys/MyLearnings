package com.test;
import java.io.IOException;
import java.util.Hashtable;

import com.ibm.mq.*;

/**
 * Java class to connect to MQ. Post and Retrieve messages.
 * 
 * Sample Command Line Parameters 
 *  -h 127.0.0.1 -p 1414 -c TEST.CHL -m MQA1 -q TEST.Q1 -u userid -x password
 */
public class MQClientTest
{
   private Hashtable<String, String> params = null;
   private Hashtable<String, Object> mqht = null;
   private String qManager;
   private String inputQName;

   /**
    * The constructor
    */
   public MQClientTest()
   {
      super();
   }

   /**
    * Make sure the required parameters are present.
    * 
    * @return true/false
    */
   private boolean allParamsPresent()
   {
      boolean b = params.containsKey("-h") && params.containsKey("-p") &&
                  params.containsKey("-c") && params.containsKey("-m") &&
                  params.containsKey("-u") && params.containsKey("-x") &&
                  params.containsKey("-q");
      if (b)
      {
         try
         {
            Integer.parseInt((String) params.get("-p"));
         }
         catch (NumberFormatException e)
         {
            b = false;
         }
      }

      return b;
   }

   /**
    * Extract the command-line parameters and initialize the MQ variables.
    * 
    * @param args
    * @throws IllegalArgumentException
    */
   private void init(String[] args) throws IllegalArgumentException
   {
      params = new Hashtable<String, String>();
      if (args.length > 0 && (args.length % 2) == 0)
      {
         for (int i = 0; i < args.length; i += 2)
         {
            params.put(args[i], args[i + 1]);
         }
      }
      else
      {
         throw new IllegalArgumentException();
      }

    /*  if (allParamsPresent())
      {
         qManager = (String) params.get("-m");
         inputQName = (String) params.get("-q");

         mqht = new Hashtable<String, Object>();

         mqht.put(CMQC.CHANNEL_PROPERTY, params.get("-c"));
         mqht.put(CMQC.HOST_NAME_PROPERTY, params.get("-h"));

         try
         {
            mqht.put(CMQC.PORT_PROPERTY, new Integer(params.get("-p")));
         }
         catch (NumberFormatException e)
         {
            mqht.put(CMQC.PORT_PROPERTY, new Integer(1414));
         }

         mqht.put(CMQC.USER_ID_PROPERTY, params.get("-u"));
         mqht.put(CMQC.PASSWORD_PROPERTY, params.get("-x"));

         // I don't want to see MQ exceptions at the console.
         MQException.log = null;
      }
      else
      {
         throw new IllegalArgumentException();
      }*/
   }

   /**
    * Method to put then get a message to/from a queue.
    */
   public void putAndGetMessage()
   {
      MQQueueManager qMgr = null;
      MQQueue        queue = null;
      MQMessage      putMessage = null;
      MQMessage      getMessage = null;

    /*  int openOptions = CMQC.MQOO_INPUT_AS_Q_DEF | CMQC.MQOO_OUTPUT + CMQC.MQOO_FAIL_IF_QUIESCING;

      MQGetMessageOptions gmo = new MQGetMessageOptions();
      gmo.options = CMQC.MQGMO_NO_WAIT + CMQC.MQGMO_FAIL_IF_QUIESCING;

      MQPutMessageOptions pmo = new MQPutMessageOptions();
      pmo.options = CMQC.MQPMO_FAIL_IF_QUIESCING;

      String msg = "Hello World, WelCome to MQ.";

      try
      {
         qMgr = new MQQueueManager(qManager, mqht);
         queue = qMgr.accessQueue(inputQName, openOptions);

         putMessage = new MQMessage();
         putMessage.writeUTF(msg);

         // put the message on the queue
         queue.put(putMessage, pmo);

         System.out.println("Message is put on MQ.");

         // get message from MQ.
         getMessage = new MQMessage();
         // assign message id to get message.
         getMessage.messageId = putMessage.messageId;

         
          * Tell the queue manager that we want a message with a specific MsgID.
          
         gmo.matchOptions = CMQC.MQMO_MATCH_MSG_ID;

         // get message options.
         queue.get(getMessage, gmo);

         String retreivedMsg = getMessage.readUTF();
         System.out.println("Message got from MQ: " + retreivedMsg);
      }
      catch (MQException e)
      {
    	 e.printStackTrace();
         System.err.println("CC=" + e.completionCode + " : RC=" + e.reasonCode);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (queue != null)
               queue.close();
         }
         catch (MQException e)
         {
            System.err.println("MQCLOSE CC=" + e.completionCode + " : RC="
                  + e.reasonCode);
         }

         try
         {
            if (qMgr != null)
               qMgr.disconnect();
         }
         catch (MQException e2)
         {
            System.err.println("MQDISC CC=" + e2.completionCode + " : RC="
                  + e2.reasonCode);
         }
      }*/
   }

   public static void main(String[] args)
   {
      System.out.println("Processing Main...");
      MQClientTest clientTest = new MQClientTest();

      try
      {
         // initialize MQ.
         clientTest.init(args);
         // put and retrieve message from MQ.
         clientTest.putAndGetMessage();
      }
      catch (IllegalArgumentException e)
      {
         System.out.println("Usage: java MQClientTest -h host -p port -c channel -m QueueManagerName -q QueueName -u userid -x password");
         System.exit(1);
      }

      System.out.println("Done!");
   }
}
