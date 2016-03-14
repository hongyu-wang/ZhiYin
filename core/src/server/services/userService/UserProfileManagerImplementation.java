package server.services.userService;

import server.model.media.MImage;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.serviceInterfaces.UserProfileManager;
import tools.utilities.Utils;

import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserProfileManagerImplementation implements UserProfileManager {
//    @Override
//    public UserProfile requestProfileData(long userKey) {
//        UserProfile profile = new UserProfile();
//        return profile;
//        //TODO request from server.
//    }

    @Override
    public UserProfile modifyUserName(UserProfile profile, String username) {
        profile.setUsername(username);
        return profile;
        //TODO request change to server.
    }

    @Override
    public UserProfile modifyDescription(UserProfile profile, String description) {
        profile.setDescription(description);
        return profile;
        //TODO request change to server.
    }

    @Override
    public UserProfile modifyDP(UserProfile profile, MImage image) {
        profile.setImageKey(image.getKey());
        return profile;
        //TODO request change to server.
    }

    @Override
    /**
     * key: 1 type 1 user
     * key: 2 type 2 user
     */
    public UserProfile getUserProfile(Long key) {
        UserProfile userProfile =  userProfileMap.get(key);
        if (userProfile == null) {
            userProfile = new UserProfile();
            if (key == 1) {
                userProfile.setKey(key);
                userProfile.setUsername("Demo 1");
                userProfile.setDescription("Demo 1 User");
            }
            if (key == 2) {
                userProfile.setKey(key);
                userProfile.setUsername("Demo 2");
                userProfile.setDescription("Demo 1 User");
            }
            userProfileMap.put(key, userProfile);
        }
        return userProfile;
    }

    private static final Map<Long, UserProfile> userProfileMap = Utils.newMap();

}
