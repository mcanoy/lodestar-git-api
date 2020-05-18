package com.redhat.labs.omp.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.redhat.labs.omp.models.GoogleChatMessage;
import com.redhat.labs.omp.rest.client.GoogleChatRestClient;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvokeWebhookResource {

    @ConfigProperty(name = "hangouts.chat.webook.key")
    String key;
    
    @ConfigProperty(name = "hangouts.chat.webook.token")
    String token;
    
    @ConfigProperty(name = "hangouts.chat.space")
    String space;
    
    @Inject
    @RestClient
    GoogleChatRestClient gChat;

    @GET
    @Path("/v1/webhook")
    public Response get(@QueryParam(value = "message") String message) {
        
        GoogleChatMessage gmessage = new GoogleChatMessage(message);
        gChat.publishMessage(gmessage, space, key, token);
        return Response.ok(String.format("{ \"message\": \"%s\"}", message)).build();
    }

}
