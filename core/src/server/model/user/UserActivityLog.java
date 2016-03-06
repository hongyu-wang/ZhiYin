package server.model.user;

import server.model.structureModels.ServerModel;

import java.util.List;

/**A class filled with all the actions a user have undertaken within the past
 * ... time.
 *
 *      - Remembers log.
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserActivityLog extends ServerModel {
    List<String> log;

    /**Returns a List of each event within the log.
     *
     * @return  The list of all events.
     */
    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }
}
