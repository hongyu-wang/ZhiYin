package server.model.serverKey;

import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class MServerKey extends ServerModel{
    /**
     * The current key number of the generator.
     */
    private long currentKey;

    public long getCurrentKey() {
        return currentKey;
    }

    public void setCurrentKey(long currentKey) {
        this.currentKey = currentKey;
    }
}
