package server.webclient.services;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import server.model.user.UserProfile;
import server.services.interfaces.models.UserProfileManager;
import server.services.factories.UserProfileManagerFactory;

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
    @Path("/getUser/{param}")
    @Produces("application/json")
    public ServerModel getUser(@PathParam("param") Long key) {
        UserProfileManager userProfileManager = UserProfileManagerFactory.createUserProfileManager();
        MText text = new MText();
        text.setKey(1);
        text.setType(1);
        text.setText("LOL");
        return text;
    }


}
