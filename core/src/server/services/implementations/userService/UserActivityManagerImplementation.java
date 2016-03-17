package server.services.implementations.userService;

import server.model.user.UserActivityLog;
import server.services.interfaces.models.UserActivityManager;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserActivityManagerImplementation implements UserActivityManager {
//    @Override
//    public UserActivityLog requestLog(long userKey) {
//        UserActivityLog log = new UserActivityLog();
//
//        List<String> logEntries = null; //Server request
//        log.setLog(logEntries);
//
//        return log;
//        //TODO request from server.
//    }

    @Override
    public UserActivityLog addEntry(UserActivityLog log, String entry) {
        log.getLog().add(entry);
        //TODO request change to server.

        return log;
    }
}
