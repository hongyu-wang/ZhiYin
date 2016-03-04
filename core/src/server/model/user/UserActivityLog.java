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
    public UserActivityLog(String events){
        events.split(";");
    }

    public void init(){}

}
