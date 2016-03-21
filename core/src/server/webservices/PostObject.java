package server.webservices;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.structureModels.ServerModel;
import server.model.user.User;

/**
 * Created by Hairuo on 2016-03-20.
 */


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
 * Created by Hairuo on 2016-03-20.
 */
public class PostObject implements Net.HttpResponseListener {

    private static PostObject ourInstance;
    private static JsonReader reader = new JsonReader();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private String className;


    public static PostObject newInstance(){
        if (ourInstance == null){
            ourInstance = new PostObject();
        }
        return ourInstance;
    }





    public void addModel(ServerModel model, String className){
        // LibGDX NET CLASS
        this.className = className;
        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl("http://localhost:8081/webservice/postServerModel");
        //httpPost.setHeader("X-Parse-Application-Id", app_id);
        //httpPost.setHeader("X-Parse-REST-API-Key", app_key);
        Json json = new Json();
        String jString = json.toJson(model);




        httpPost.setContent(jString+className);
        Gdx.net.sendHttpRequest(httpPost,this);
    }


    @Override
    public void cancelled() {

    }

    @Override
    public void handleHttpResponse(Net.HttpResponse httpResponse) {
        final int statusCode = httpResponse.getStatus().getStatusCode();
        try {
            rOjbect = objectMapper.readValue(httpResponse.getResultAsString(), User.class);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(statusCode + " " + httpResponse.getResultAsString());
    }

    @Override
    public void failed(Throwable t) {
        System.out.println(t.getMessage());
    }

    public String getClassName() {
        return className;
    }


}

