package server.services.interfaces.models;

import server.model.user.UserActivityLog;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserActivityManager {

    /**Add an entry to the log of activities.
     *
     * @param log   The user's log.
     * @param entry The event string.
     * @return
     */
    UserActivityLog addEntry(UserActivityLog log, String entry);
}
