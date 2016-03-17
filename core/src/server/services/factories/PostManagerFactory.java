package server.services.factories;

import server.services.implementations.socialService.PostManagerImplementation;
import server.services.interfaces.models.PostManager;


/**
 * @author rsang
 */
public class PostManagerFactory {

    private static PostManager PostManager;

    public static PostManager createPostManager() {
        if (PostManager == null) {
            PostManager  = new PostManagerImplementation();
        }
        return PostManager;
    }

    private PostManagerFactory(){}

}
