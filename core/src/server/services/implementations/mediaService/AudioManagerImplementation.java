package server.services.implementations.mediaService;

import server.model.media.MAudio;
import server.services.interfaces.models.AudioManager;
import server.webclient.WebServiceClient;
import server.webclient.webErrors.WebRequestException;
import tools.AudioTools.AudioCreator;

/**
 * Created by Kevin on 3/6/2016.
 */
public class AudioManagerImplementation implements AudioManager {

//    @Override
//    public MAudio requestAudio(long key) {
//        MAudio audio = new MAudio();
//        audio.setKey(key);
//
//        return audio;
//    }

    public MAudio createAudio(String path) throws WebRequestException{
        MAudio audio = AudioCreator.createFromFilePath(path);

        audio.setKey(WebServiceClient.getSerial());

        return audio;
    }

}