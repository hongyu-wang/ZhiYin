package tools.services;

import tools.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface UserManager {
    User requestUserData();
    void modifyLog(User user, String newEntry);
    void modifyUser();
}
