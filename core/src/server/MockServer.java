package server;

import yonghu.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**Note, everything within MockServer should remain static.
 *
 * Created by Kevin Zheng on 2016-02-18.
 */
public class MockServer {
    private static Hashtable<String, String> user_passTable;
    public MockServer(){
        user_passTable = new Hashtable<String, String>();
    }

    /**Authenticates the user based on their username and password.
     *
     * @param username
     * @param password
     * @return True if the username and passwords match.
     */
    public static boolean checkLogin(String username, String password){
        return user_passTable.get(username).equals(password);
    }

    /**Gets all required user information.
     *
     * @return  Returns all the user information in a User class, read from database.
     */
    public static String getUserData(String user) throws IOException {
        BufferedReader user_info = new BufferedReader(new FileReader(user));
        String output = "";

    }
}
