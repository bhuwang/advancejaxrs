/**
 * 
 */
package com.bhuwan.advancejaxrs.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * @author bhuwan
 *
 */
@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext reqContext, ContainerResponseContext respContext) throws IOException {
        respContext.getHeaders().add("X-Powered-By", "Bhuwan - Advance Jaxrs");
    }

}
