package server.services.factories;

import server.services.implementations.socialService.GroupManagerImplementation;
import server.services.interfaces.models.GroupManager;

/**
 * @author rsang
 */
public class GroupManagerFactory {

    private static GroupManager GroupManager;

    public static GroupManager createGroupManager() {
        if (GroupManager == null) {
            GroupManager  = new GroupManagerImplementation();
        }
        return GroupManager;
    }

    private GroupManagerFactory(){}

}
