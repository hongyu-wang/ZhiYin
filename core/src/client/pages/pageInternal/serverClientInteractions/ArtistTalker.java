package client.pages.pageInternal.serverClientInteractions;

import server.model.media.MMusic;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-22.
 */
public class ArtistTalker extends Talkers {

    //--Interface Fields
    private String name;
    private List<MMusic> musicList;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public List<MMusic> getMusicList() {
        return musicList;
    }

    /*------------------------------------------------------------------------*/

    @Override
    public void init() {

    }

    /*------------------------------------------------------------------------*/

    @Override
    public void pull() {

    }

    @Override
    public void push() {

    }

    @Override
    public boolean isUpdated() {
        return false;
    }

    @Override
    public void update(float dt) {

    }
}
