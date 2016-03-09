package server.model.soundCloud;

import server.model.media.MText;
import server.model.social.MPost;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MMusicPost extends MPost {
    private long genre;
    private long band;

    public long getGenre() {
        return genre;
    }

    public void setGenre(long genre) {
        this.genre = genre;
    }

    public long getBand() {
        return band;
    }

    public void setBand(long band) {
        this.band = band;
    }
}
