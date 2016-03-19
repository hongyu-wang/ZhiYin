package server.model.media;

import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MMusic extends ServerModel {
    /**
     * The name of the music.
     */
    String name;

    MAudio song;

    /**Returns the title of the music.
     *
     * @return  The title string.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MAudio getSong() { return song; }

    public void setSong(MAudio song) {this.song = song;}
}
