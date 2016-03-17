package server.webservices.services;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import server.services.interfaces.models.UserProfileManager;
import server.webservices.factories.UserProfileManagerFactory;
import tools.serverTools.server.MockServer;
import tools.serverTools.server.ServerInteraction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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

}