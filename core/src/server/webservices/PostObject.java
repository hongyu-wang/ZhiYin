package server.webservices;

import client.pages.pageInternal.modelStorage.ModelStorage;
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
import tools.serverTools.generators.Tags;

import javax.ws.rs.core.Response;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

/**
 * Created by Hairuo on 2016-03-20.
 */
public class PostObject implements Net.HttpResponseListener {
    private JsonReader reader = new JsonReader();
    private ObjectMapper objectMapper = new ObjectMapper();
    private String className;


    public static PostObject newInstance(){
        return new PostObject();
    }




    /**
     * Posts a model to the server
     *
     * @param model     model to be posted
     * @param className name of the class of the model
     */
    public void addModel(ServerModel model, String className){
        // LibGDX NET CLASS

        className = Tags.ID_TAGS.parseTag(className);
        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl("http://"+ ModelStorage.ipAddress+":8081/webservice/postServerModel");
        //httpPost.setHeader("X-Parse-Application-Id", app_id);
        //httpPost.setHeader("X-Parse-REST-API-Key", asspp_key);
        String jString = "";
        try {
            jString = objectMapper.writeValueAsString(model);
        }catch(Exception e){
            System.out.println(e);
        }




        httpPost.setContent(jString+className);
        Gdx.net.sendHttpRequest(httpPost,this);
    }


    @Override
    public void cancelled() {
        System.out.println("POSTOBJECT CANCELLED: " + className);
    }

    @Override
    public void handleHttpResponse(Net.HttpResponse httpResponse) {
        System.out.println(httpResponse.getStatus());
    }

    @Override
    public void failed(Throwable t) {
        System.out.println(t.getMessage());
    }

    public String getClassName() {
        return className;
    }


}

