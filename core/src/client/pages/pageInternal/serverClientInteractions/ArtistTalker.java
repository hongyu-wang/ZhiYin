package client.pages.pageInternal.serverClientInteractions;

import server.model.media.MMusic;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-22.
 */
public class ArtistTalker extends Talkers {

    public String name;
    public List<MMusic> musicList;


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
