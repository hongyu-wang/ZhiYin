package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Updatable;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public abstract class Talkers implements Updatable{
    protected static long totalmodels;
    protected ModelStorage modelStorage = ModelStorageFactory.createModelStorage();
    public Talkers(){

    }

    public abstract void pull();

    public abstract void push();

    public abstract boolean isUpdated();


    protected boolean checkOriginalUpdate() {
        for(long i = 0; i < totalmodels ; i++)
            if(modelStorage.getModel(i) == null)
                return false;
        return true;
    }
}
