/**
 * 
 */
package com.bhuwan.advancejaxrs.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author bhuwan
 *
 */
public class InvocationDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        InvocationDemo demo = new InvocationDemo();
        Invocation invocation = demo.prepareRequestForMessagesByYear(2016);
        Response invoke = invocation.invoke();
        // Since this returns list of messages you cannot cast this to Message class only. You have to use GenericType
        // Message readEntity = invoke.readEntity(Message.class);
        System.out.println(invoke.getStatus());

    }

    private Invocation prepareRequestForMessagesByYear(int year) {
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target("http://localhost:8080/advancejaxrs/api/");
        WebTarget messageTarget = baseTarget.path("messages");
        return messageTarget.queryParam("year", year).request(MediaType.APPLICATION_JSON).buildGet();
    }

}
