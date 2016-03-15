package server.webservices;

import server.model.user.UserProfile;
import server.services.interfaces.models.UserProfileManager;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    public UserProfile getUser(@PathParam("param") Long key) {
        UserProfileManager userProfileManager = UserProfileManagerFactory.createUserProfileManager();
        //return userProfileManager.getUserProfile(key);
        return null;
    }

}
