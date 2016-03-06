package server.services.socialService;

import tools.ServiceList;

/**
 * Created by Hairuo on 2016-03-03.
 */
public interface MessageParser {
    /**
     * Parses string messages into components
     */

    public ServiceList<MediaModel> parseString();


}
