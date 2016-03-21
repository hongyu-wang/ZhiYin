package server.webservices;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.user.User;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * A singleton used to request models from the server
 */
public class RequestObject implements Net.HttpResponseListener {

    private static RequestObject ourInstance;
    private JsonReader reader = new JsonReader();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Object rOjbect;
    private String className;

    public static RequestObject newInstance(){

        if (ourInstance == null) {
            ourInstance = new RequestObject();
        }
        return ourInstance;

    }

    /**
     * Retrieves a model from the server
     *
     * @param className name of the class of the model
     * @param key       id key of the model
     */
    public void getModel(String className, long key) {
        // LibGDX NET CLASS
        this.className = className;
        Net.HttpRequest httpGet = new Net.HttpRequest(Net.HttpMethods.GET);
        httpGet.setUrl("http://localhost:8081/webservice/getServerModel/" + key);
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
        final int statusCode = httpResponse.getStatus().getStatusCode();
        try {
            rOjbect = objectMapper.readValue(httpResponse.getResultAsString(), Class.forName(className));
            String line = "lol";
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
