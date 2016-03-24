package server.webclient.services;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import server.services.interfaces.models.UserProfileManager;
import server.webservices.PostObject;
import tools.serverTools.generators.Tags;
import tools.serverTools.server.MockServer;
import tools.serverTools.server.ServerInteraction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.structureModels.ServerModel;
import server.model.user.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * @author rsang
 */
@Path("/webservice")
public class WebService{

    @GET
    @Path("/param/{param}")
    @Produces("text/plain")
    public String getClichedMessage(@PathParam("param") String msg) {
        return msg;
    }

    /**
     *  Using Jackson.
     *
     */
    @GET
    @Path("/getServerModel/{param}")
    @Produces("application/json")
    public ServerModel getServerModel(@PathParam("param") Long key) {
        MockServer mockServer = ServerInteraction.getServer();

        return mockServer.getModel(key);
    }

    @GET
    @Path("/getServerKey/{param}")
    @Produces("application/json")
    public Long getServerKey(@PathParam("param") Long key){
        MockServer mockServer = ServerInteraction.getServer();
        return mockServer.getSerial();
    }

    /**
     *  Using Jackson.
     *
     */
    @POST
    @Path("/postServerModel")
    @Consumes("*/*")
    public Response postServerModel(String json) {
        MockServer mockServer = ServerInteraction.getServer();
        ObjectMapper objectMapper = new ObjectMapper();
        ServerModel model = null;
        int tag = Integer.parseInt(json.substring(json.length()-4));
        System.out.println(tag+1);
        String className = Tags.ID_TAGS.getName(tag);
        System.out.println(className);
        json = json.substring(0, json.length()-4);

        try {
            Class name = Class.forName(className);
            model = (ServerModel)objectMapper.readValue(json, name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mockServer.setModel(model);
        return Response.status(Response.Status.OK).build();

    }



}