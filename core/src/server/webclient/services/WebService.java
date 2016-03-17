package server.webclient.services;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import tools.serverTools.server.MockServer;
import tools.serverTools.server.ServerInteraction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;

/**
 * @author rsang
 */
@Path("/webservice")
public class WebService {

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

    @PUT
    @Path("/putServerModel/{param}")
    public void putServerModel(@PathParam("param") ServerModel model){

    }


}