package server.model.soundCloud;

import server.model.media.MText;

import javax.xml.soap.Text;
import java.util.List;

/**
 * Created by Hairuo on 2016-03-09.
 */
public class MPlaylist {
    private List<Long> songs;
    private MText description;

    public List<Long> getSongs() {
        return songs;
    }

    public void setSongs(List<Long> songs) {
        this.songs = songs;
    }

    public MText getDescription() {
        return description;
    }

    public void setDescription(MText description) {
        this.description = description;
    }
}
