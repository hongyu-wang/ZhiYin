package server.webclient.services;

import server.model.structureModels.ServerModel;
import tools.serverTools.server.MockServer;
import tools.serverTools.server.ServerInteraction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author rsang
 */
@Path("/hashtagservice")
public class HashtagService {

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
    @Path("/getHashtagByName/{param}")
    @Produces("application/json")
    public long getHashtagByName(@PathParam("param") String hashtag) {
        MockServer mockServer = ServerInteraction.getServer();
        long hashtagKey = mockServer.getUserKeybyName(hashtag);

        return hashtagKey;
    }


}