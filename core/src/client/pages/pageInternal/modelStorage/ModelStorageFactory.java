package client.pages.pageInternal.modelStorage;

import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-19.
 */
public class ModelStorageFactory {
    private static ModelStorage modelStorage;

    private ModelStorageFactory(){}

    public static ModelStorage createModelStorage(){
        if(modelStorage == null){
            modelStorage = new ModelStorage();
        }
        return modelStorage;
    }

    public static ModelStorage createModelStorage(User user){
        if(modelStorage == null){
            modelStorage = new ModelStorage(user);
        }
        modelStorage.user = user;
        return modelStorage;
    }
}
