package server.services.messengerService;

import server.model.media.MediaModel;
import tools.ServiceList;

import javax.print.attribute.standard.Media;

/**
 * Created by Hairuo on 2016-03-03.
 */
public interface MessageParser {
    /**
     * Parses string messages into components
     */

    public ServiceList<MediaModel> parseString();


}
