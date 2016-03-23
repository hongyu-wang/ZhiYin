package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Updatable;
import server.model.user.User;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public abstract class Talkers implements Updatable{
    protected static long totalOriginalModels;
    protected static ModelStorage modelStorage = ModelStorageFactory.createModelStorage();

    /*------------------------------------------------------------------------*/

    public abstract void init();


    /*------------------------------------------------------------------------*/

    public abstract void pull();

    public abstract void push();

    public abstract boolean isUpdated();



















    protected boolean checkOriginalUpdate() {
        for(long i = 1; i < totalOriginalModels; i++) {
//            System.out.println(i);
            if (modelStorage.getModel(i) == null)
                return false;
        }
        return true;
    }

    protected User getMainUser(){
        return modelStorage.getMainUser();
    }

}
