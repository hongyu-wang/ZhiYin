package client.stateInterfaces;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import server.model.social.MDiaryPost;
import server.model.soundCloud.MBand;

import java.util.List;

/**
 *
 * Created by Hongyu Wang on 4/3/2016.
 */
public interface Profile {
    void addPost(MDiaryPost post);
    void addFollowing(MBand artist, Image image);

    List<Long> getCurrentArtists();

    List<Long> getCurrentDiaries();

}
