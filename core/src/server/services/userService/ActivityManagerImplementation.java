package server.services.userService;

import server.model.user.User;
import server.model.user.UserActivityLog;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class ActivityManagerImplementation implements ActivityManager {
    @Override
    public UserActivityLog requestLog(String user) {
        UserActivityLog log = new UserActivityLog();
        //TODO request from server.
        return log;
    }

    @Override
    public User addEntry(User user, String entry) {
        user.getLog().getLog().add(entry);
        //TODO request change on server.
        return user;
    }
}
