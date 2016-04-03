package tools.utilities;

import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.pages.pageInternal.serverClientInteractions.VeryBeginningInitializer;

/**
 * Created by Kevin Zheng on 2016-03-23.
 */
public class Test {
    static LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
    static VeryBeginningInitializer vbi;
    static long key = 0;
    public static void main(String [] args){
        vbi = TalkerFactory.VeryBeginningInitializer();

        vbi.pull();

        while(true){
            run();
        }
    }

    public static void run(){
        update();
    }

    public static void update(){
        vbi.update(0);
        System.out.println(key++);
        System.out.println(vbi.isWaiting());
        System.out.println(vbi.isUpdated());
    }

}
