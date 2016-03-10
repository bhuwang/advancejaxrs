/**
 * 
 */
package com.bhuwan.advancejaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bhuwan.advancejaxrs.model.MyDate;

/**
 * url: http://localhost:8080/advancejaxrs/api/date/yesterday
 * 
 * @author bhuwan
 *
 *
 */
@Path("/date/{dateString}")
public class DateResource {

    @GET
    public String getRequestedDate(@PathParam("dateString") MyDate myDate) {
        return "Got " + myDate.toString();
    }
}
