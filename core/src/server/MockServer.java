package server;

import java.util.Hashtable;

/**
 * Created by Kevin Zheng on 2016-02-18.
 */
public class MockServer {
    Hashtable<String, String> user_passTable;
    public MockServer(){
        user_passTable = new Hashtable<String, String>();

    }

    public static boolean checkLogin(String username, String password){
        return true;
    }
}
