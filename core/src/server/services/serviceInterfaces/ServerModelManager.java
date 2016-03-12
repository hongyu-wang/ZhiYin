package server.services.serviceInterfaces;

import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-11.
 */
public interface ServerModelManager {

    /**Requests a model from the server.
     *
     * @param key   The key long.
     * @return      The required server model.
     */
    <E> E requestModel(long key) throws Exception;

    /**Pushes a modified model object to the server.
     *
     * @param model The servermodel.
     */
    void pushModel(ServerModel model);
}
