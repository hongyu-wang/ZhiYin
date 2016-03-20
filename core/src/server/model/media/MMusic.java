package server.model.media;

import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MMusic extends ServerModel {

    String name;

    long song;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSong() { return song; }

    public void setSong(MAudio song) {this.song = song.getKey();}
}
