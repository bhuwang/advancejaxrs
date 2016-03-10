/**
 * 
 */
package com.bhuwan.advancejaxrs.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bhuwan.advancejaxrs.messanger.model.Message;

/**
 * @author bhuwan
 *
 */
public class RestApiClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        //String message = client.target("http://localhost:8080/advancejaxrs/api/messages/2").request(MediaType.APPLICATION_JSON).get(String.class);
        //Message message = response.readEntity(Message.class);
        WebTarget baseTarget = client.target("http://localhost:8080/advancejaxrs/api/");
        WebTarget messageTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messageTarget.path("{messageId}");
        
        // Get Construct
        Message message1 = singleMessageTarget.resolveTemplate("messageId", "1").request(MediaType.APPLICATION_JSON).get(Message.class);
        Message message2 = singleMessageTarget.resolveTemplate("messageId", "2").request(MediaType.APPLICATION_JSON).get(Message.class);
        
        System.out.println(message1);
        System.out.println("=>> Next Message");
        System.out.println(message2);
        
        // Post Construct
        Message newMessage = new Message(3,"Hello Bhuwan","Kedar Poudel");
        Response postResponse = messageTarget.request().post(Entity.json(newMessage));
        System.out.println("=>> Post Construct");
        Message readEntity = postResponse.readEntity(Message.class);
        System.out.println(readEntity);
        
        // Put Construct
        Message message = new Message(3,"Sampurna Bhattachan","Sampurna Poudel");
        Response put = singleMessageTarget.resolveTemplate("messageId", "4").request(MediaType.APPLICATION_JSON).put(Entity.json(message));
        System.out.println("=>> Put Construct");
        Message messageEntity = put.readEntity(Message.class);
        System.out.println(messageEntity);
    }

}
