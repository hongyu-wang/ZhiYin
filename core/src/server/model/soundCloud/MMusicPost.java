package server.model.soundCloud;

import server.model.social.MPost;

/**
 * Music post model
 * Basically represents a soundcloud music post
 */
public class MMusicPost extends MPost {

    /**
     * Id of the Genre of the piece of music
     */
    private long genre;

    /**
     * Id of the Band of the music piece
     */
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
