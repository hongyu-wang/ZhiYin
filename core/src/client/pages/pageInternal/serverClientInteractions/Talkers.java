package client.pages.pageInternal.serverClientInteractions;

import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Updatable;
import server.model.user.User;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public abstract class Talkers implements Updatable{
    protected static long totalOriginalModels;
    protected static LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();

    private boolean waiting = false;

    /*------------------------------------------------------------------------*/

    public abstract void init();


    /*------------------------------------------------------------------------*/

    public abstract void pull();

    public abstract void push();

    public abstract boolean isUpdated();

    public boolean isWaiting(){
        return waiting;
    }













    protected void setWaiting(boolean waiting){
        this.waiting = waiting;
    }

    protected boolean checkOriginalUpdate() {
        for(long i = 1; i < totalOriginalModels; i++) {
//            System.out.println(i);
            if (localDatabase.getModel(i) == null)
                return false;
        }
        for(long i = 20000; i < 20010; i++){
            if (localDatabase.getModel(i) == null)
                return false;
        }
        return true;
    }

    protected User getMainUser(){
        return localDatabase.getMainUser();
    }

}
