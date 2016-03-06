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
    public UserDiaryContent requestAllDiaryContent(long userKey) {
        UserDiaryContent diary = new UserDiaryContent();

        List<Long> keys = null; //Server request
        diary.setDiaryKeys(keys);

        List<DiaryPost> diaryPosts = new ServiceList<DiaryPost>();
        for(long key: diary.getDiaryKeys()){
            DiaryPost post = null;  //MusicDiaryManagerImplementation request
            diaryPosts.add(post);
        }
        diary.setDiaryposts(diaryPosts);

        return diary;
        //TODO request from server
    }

    @Override
    public User addDiaryPost(User user, DiaryPost diaryPost) {
        user.getDiary().getDiaryKeys().add(diaryPost.getKey());
        user.getDiary().getDiaryposts().add(diaryPost);
        return user;
        //TODO request change to server
    }
}
