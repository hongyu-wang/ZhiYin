package server.services.mediaService;

<<<<<<< HEAD
import server.model.media.Audio;

/**
 * Created by Kevin on 3/6/2016.
 */
public class AudioManagerImplementation implements AudioManager{


    public void startRecording(){

    }

    public Audio stopRecording(){

    }

    public void playAudio(Audio audio){

    }

    public String[] requestAudioInfo(){

    }

=======
import server.model.media.MAudio;

/**
 * Created by Kevin Zheng on 2016-03-07.
 */
public class AudioManagerImplementation implements AudioManager{
    @Override
    public MAudio requestAudio(long key) {
        MAudio audio = new MAudio();
        audio.setKey(key);

        //TODO Implement MAudio.

        //TODO request from server the audio.
        return null;
    }
>>>>>>> origin/master
}
