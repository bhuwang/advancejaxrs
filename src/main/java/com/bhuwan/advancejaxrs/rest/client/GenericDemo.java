/**
 * 
 */
package com.bhuwan.advancejaxrs.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.bhuwan.advancejaxrs.messanger.model.Message;

/**
 * @author bhuwan
 *
 */
public class GenericDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target("http://localhost:8080/advancejaxrs/api/");
        WebTarget messageTarget = baseTarget.path("messages");
        List<Message> list = messageTarget.queryParam("year", 2015).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Message>>(){});
        System.out.println(list);
    }

}
