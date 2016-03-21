package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Updatable;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public abstract class Talkers implements Updatable{
    protected long totalmodels = 0;
    protected ModelStorage modelStorage = ModelStorageFactory.createModelStorage();
    public Talkers(){
        update(0);
    }

    public abstract void pull();

    public boolean updated() {
        for(long i = 0; i < totalmodels ; i++)
            if(modelStorage.getModel(i) == null)
                return false;
        return true;
    }
}
