package server.services.userService;

import server.model.user.User;
import server.model.user.UserActivityLog;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserActivityManagerImplementation implements UserActivityManager {
    @Override
    public UserActivityLog requestLog(long userKey) {
        UserActivityLog log = new UserActivityLog();

        List<String> logEntries = null; //Server request
        log.setLog(logEntries);

        return log;
        //TODO request from server.
    }

    @Override
    public UserActivityLog addEntry(UserActivityLog log, String entry) {
        log.getLog().add(entry);
        //TODO request change to server.

        return log;
    }
}
