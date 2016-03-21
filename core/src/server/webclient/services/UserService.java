package server.webclient.services;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import server.model.user.UserProfile;
import server.services.interfaces.models.UserProfileManager;
import server.services.factories.UserProfileManagerFactory;
import tools.serverTools.server.MockServer;
import tools.serverTools.server.ServerInteraction;

import javax.ws.rs.*;

/**
 * @author rsang
 */
@Path("/userservice")
public class UserService {

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
    @Path("/getUserByName/{param}")
    @Produces("application/json")
    public long getUserByName(@PathParam("param") String username) {
        MockServer mockServer = ServerInteraction.getServer();
        long userKey = mockServer.getUserKeybyName(username);

        return userKey;
    }


}
