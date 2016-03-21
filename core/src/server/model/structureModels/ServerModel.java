package server.model.structureModels;

/**All KeyObjects must contain a string key.
 *
 * Created by Kevin Zheng on 2016-03-04.
 */
public class ServerModel {
    /**
     * The key to the model.
     */
    protected long accessKey;

    /**Gets the key to the model.
     *
     * @return  The key long.
     */
    public long getKey() {
        return accessKey;
    }

    public void setKey(long accessKey) {
        this.accessKey = accessKey;
    }


}
