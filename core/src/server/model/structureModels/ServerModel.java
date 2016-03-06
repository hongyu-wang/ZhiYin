package server.model.structureModels;

/**All KeyObjects must contain a string key.
 *
 * Created by Kevin Zheng on 2016-03-04.
 */
public class ServerModel {
    protected long accessKey;

    public long getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(long accessKey) {
        this.accessKey = accessKey;
    }
}
