package server.services.userService;

import server.model.social.DiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import tools.ServiceList;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserDiaryManagerImplementation implements UserDiaryManager {
    @Override
    public UserDiaryContent requestAllDiaryContent(long dairyKey) {
        UserDiaryContent diary = new UserDiaryContent();
        diary.setKey(dairyKey);

        List<Long> keys = null; //Server request
        diary.setDiaryKeys(keys);

        return diary;
        //TODO request from server
    }

    @Override
    public UserDiaryContent addDiaryPost(UserDiaryContent diary, DiaryPost diaryPost) {
        diary.getDiaryKeys().add(diaryPost.getKey());
        return diary;
        //TODO request change to server
    }
}
