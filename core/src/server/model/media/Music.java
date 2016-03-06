package server.model.media;

import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class Music extends ServerModel {
    String name;
    Audio music;

    /**Returns the title of the music.
     *
     * @return  The title string.
     */
    public String getName() {
        return name;
    }

    /**Returns the audio which represents the music file.
     *
     * @return  The audio file.
     */
    public Audio getMusic() {
        return music;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setMusic(Audio music) {
        this.music = music;
    }
}
