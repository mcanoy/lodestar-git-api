package com.redhat.labs.omp.rest.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.redhat.labs.omp.models.GoogleChatMessage;

@Path("/v1/spaces")
@RegisterRestClient(configKey = "hangouts.chat.api")
public interface GoogleChatRestClient {

    //TODO don't publish this
    @Path("/{space}/messages")
    @POST
    @ClientHeaderParam(name="charset", value = "UTF-8")
    @Produces("application/json")
    @Consumes("application/json")
    Response publishMessage(GoogleChatMessage message, @PathParam("space") @Encoded String space, @QueryParam("key") String key, @QueryParam("token") String token);
}
