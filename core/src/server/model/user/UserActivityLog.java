package server.model.user;

import tools.ServiceList;

/**A class filled with all the actions a user have undertaken within the past
 * ... time.
 *
 *      - Remembers log.
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserActivityLog {
    ServiceList<String> log;

    /**Returns a ServiceList of each event within the log.
     *
     * @return  The list of all events.
     */
    public ServiceList<String> getLog() {
        return log;
    }

    public void setLog(ServiceList<String> log) {
        this.log = log;
    }
}
