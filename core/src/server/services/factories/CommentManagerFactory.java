package server.services.factories;

import server.services.implementations.socialService.CommentManagerImplementation;
import server.services.interfaces.models.CommentManager;

/**
 * @author rsang
 */
public class CommentManagerFactory {

    private static CommentManager CommentManager;

    public static CommentManager createCommentManager() {
        if (CommentManager == null) {
            CommentManager  = new CommentManagerImplementation();
        }
        return CommentManager;
    }

    private CommentManagerFactory(){}

}
