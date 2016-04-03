package server.services.implementations.userService;

import server.model.social.MDiaryPost;
import server.model.user.UserDiaryContent;
import server.services.interfaces.models.UserDiaryManager;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserDiaryManagerImplementation implements UserDiaryManager {
//    @Override
//    public UserDiaryContent requestAllDiaryContent(long dairyKey) {
//        UserDiaryContent diary = new UserDiaryContent();
//        diary.setKey(dairyKey);
//
//        List<Long> keys = null; //Server request
//        diary.setDiaryKeys(keys);
//
//        return diary;
//    }

    @Override
    public UserDiaryContent addDiaryPost(UserDiaryContent diary, MDiaryPost diaryPost) {
        diary.getDiaryKeys().add(diaryPost.getKey());
        return diary;
    }
}
