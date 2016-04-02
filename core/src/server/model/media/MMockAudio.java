package server.model.media;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class MMockAudio extends MAudio {

    private String filepath;

    public MMockAudio(){}


    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
