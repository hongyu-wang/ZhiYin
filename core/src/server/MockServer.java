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
    public MockServer() throws IOException{
        init();
    }

    private void init() throws IOException{
        user_passTable = new Hashtable<String, String>();

        getUserPass();
    }

    private void getUserPass() throws IOException{
        BufferedReader user_info = new BufferedReader(new FileReader("user_pass.txt"));

        String[] info = user_info.readLine().split(" ");
        while(!info.equals("")) {
            user_passTable.put(info[0], info[1]);
        }
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
    public static String[] getUserData(String user) throws IOException {
        BufferedReader user_info = new BufferedReader(new FileReader(user));
        String[] output = new String[1];

        String input = user_info.readLine();
        int count = 0;
        while (!input.equals("")){
            output[count] = input;
            count++;
        }

        return output;
    }
}
