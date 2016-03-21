package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class VeryBeginningIntializer extends Talkers{

    public VeryBeginningIntializer(){


    }


    @Override
    public void update(float dt) {
        modelStorage.loginUser("Alice");
    }
}
