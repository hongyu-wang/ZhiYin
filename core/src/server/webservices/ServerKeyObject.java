package server.webservices;

import tools.serverTools.databases.LocalDatabase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Hairuo on 2016-03-23.
 */
public class ServerKeyObject implements Net.HttpResponseListener {
    private LocalDatabase localDatabase;
    private JsonReader reader = new JsonReader();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Object rOjbect;
    private String className;

    public ServerKeyObject(LocalDatabase localDatabase){
        this.localDatabase = localDatabase;
    }

    public static ServerKeyObject getInstance(LocalDatabase localDatabase){
        return new ServerKeyObject(localDatabase);
    }


    /**
     * Retrieves a model from the server
     *
     */
    public void getKey() {
        // LibGDX NET CLASS
        Net.HttpRequest httpGet = new Net.HttpRequest(Net.HttpMethods.GET);
        httpGet.setUrl("http://localhost:8081/webservice/getServerKey");
        //httpGet.setHeader("Content-Type", "application/json");
        //httpGet.setHeader("X-Parse-Application-Id", app_id);
        //httpGet.setHeader("X-Parse-REST-API-Key", app_key);
        Gdx.net.sendHttpRequest(httpGet, this);
    }

    @Override
    public void cancelled() {

    }

    @Override
    public void handleHttpResponse(Net.HttpResponse httpResponse) {
        try {
            long key = Long.parseLong(httpResponse.getResultAsString());
            localDatabase.putGeneratedKey(key);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void failed(Throwable t) {
        System.out.println(t.getMessage());
    }

    public Object getrOjbect() {
        return rOjbect;
    }

    public void setrOjbect(Object rOjbect) {
        this.rOjbect = rOjbect;
    }
}
