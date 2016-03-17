package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecutePlayMusic;
import client.events.executables.internalChanges.TestExecutable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import org.robovm.apple.foundation.*;
import server.model.media.MAudio;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioPlayer;
import tools.AudioTools.AudioRecorder;

import java.io.File;

/**
 * This is the now playing page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class NowPlaying extends NowPlayingShell {
    private Music music;
    private MAudio song;

    private AudioPlayer player;
    private AudioRecorder r;

    public void init() {
        super.init();

        r = new AudioRecorder();
        Slider slider = new Slider(0, 100, 1, false, new Slider.SliderStyle());
        slider.setBounds(80, 300, 295, 50);
        slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println('a');
            }
        });
        Table table = new Table();
        table.add(slider).minWidth(100).fillX().colspan(3);
        table.setBounds(0, 0, 375, 1334/2);

        stage.addActor(table);

    }

    @Override
    public void dispose() {


    }


    public Music getMusic() {

        return music;
    }

    public AudioPlayer getPlayer(){
        return player;
    }

    //public void setMusic(String trackName) {
        //this.music = Gdx.audio.newMusic(Gdx.files.internal(trackName));

    //}

    public void setMusic(String path) throws NSErrorException {

        //String p = NSBundle.getMainBundle().findResourcePath(path,"mp3");

        File mp3 = new File(new File("/Users/JimGuo/Desktop/ZhiYin/android/assets"),path);

        NSURL url = new NSURL(mp3.toURI().toString());


        player = new AudioPlayer(url);
    }

    public void setMusic2(MAudio s) throws NSErrorException{
        player = new AudioPlayer(s);
    }

    public AudioRecorder getr(){
        return r;
    }


}
