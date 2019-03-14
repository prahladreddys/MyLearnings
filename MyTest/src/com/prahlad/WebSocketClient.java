package com.prahlad;

import java.net.URI;

import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WebSocketClient {
	public static void main(String[] args) {
		connectSocket();
	}

	private static void connectSocket() {
		try {
//			URI uri = new URI("wss",null,"wsg.qa.ciphercloud.in","8980","/wsg/connect",null,null);
			URI uri = new URI("wss", null, "wsg.qa.ciphercloud.in", 8980, "/wsg/connect",null,null);
			//URI uri = new URI(env.getWsgScheme(), null, env.getWsgIP(), env.getWsgPort(), path, null, null);
			ClientSocket socket = new ClientSocket();
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
//			ClientEndpointConfig cec = ClientConfig.getSSLConfig();
			Session session = container.connectToServer(socket, uri);
			if(session.isOpen()){
				session.getBasicRemote().sendText("ping");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ClientSocket extends Endpoint implements MessageHandler.Whole<String>{

	@Override
	public void onMessage(String arg0) {
		System.out.println("on message");
	}

	@Override
	public void onOpen(Session arg0, EndpointConfig arg1) {
		System.out.println("on open");
	}
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("On close");
    }
}
