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
import java.util.Arrays;
import java.util.List;

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
    @Produces("*/*")
    public String getServerModel(@PathParam("param") Long key) {
        MockServer mockServer = ServerInteraction.getServer();
        ServerModel model = mockServer.getModel(key);
        ObjectMapper objectMapper = new ObjectMapper();
        String className = Tags.ID_TAGS.parseTag(model.getClass().getCanonicalName());
        String jString = "";
        try {

            jString = objectMapper.writeValueAsString(model);
        }catch(Exception e){
            System.out.println(e);
        }
        return jString+className;
    }

    @GET
    @Path("/getServerKey")
    @Produces("application/json")
    public Long getServerKey(){
        MockServer mockServer = ServerInteraction.getServer();
        return mockServer.getSerial();
    }

    @GET
    @Path("/update")
    @Produces("application/json")
    public Long[] update(){
        MockServer mockServer = ServerInteraction.getServer();
        List<Long> list = mockServer.getUpdates();

        return list.toArray(new Long[list.size()]);
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
        String[] models = null;

//        ServerModel model = null;
//        int tag = Integer.parseInt(json.substring(json.length()-4));
//        String className = Tags.ID_TAGS.getName(tag);
//        json = json.substring(0, json.length()-4);

        try {
            //Class name = Class.forName(className);
            Class newClass = String[].class;
            models = (String[])objectMapper.readValue(json, newClass);
            for(String model : models) {
                ServerModel realModel;
                int tag = Integer.parseInt(model.substring(model.length()-4));
                String className = Tags.ID_TAGS.getName(tag);
                model = model.substring(0, model.length()-4);
                Class name = Class.forName(className);
                realModel = (ServerModel)objectMapper.readValue(model, name);
                mockServer.setModel(realModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).build();
    }
}