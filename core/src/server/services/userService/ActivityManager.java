package server.services.userService;

import server.model.user.User;
import server.model.user.UserActivityLog;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface ActivityManager {
    /**Requests the log of activities thus far.
     *
     * @param user  The username
     * @return  The UserActivity model of recent activities.
     */
    UserActivityLog requestLog(String user);

    /**Add an entry to the log of activities.
     *
     * @param user  The user.
     * @param entry The event string.
     * @return
     */
    User addEntry(User user, String entry);
}
