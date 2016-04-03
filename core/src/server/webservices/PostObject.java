package server.webservices;

import tools.serverTools.databases.LocalDatabase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.structureModels.ServerModel;

/**
 * Created by Hairuo on 2016-03-20.
 */


import tools.serverTools.generators.Tags;

import java.util.ArrayList;

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
     */
    public void addModel(ServerModel[] model){
        // LibGDX NET CLASS
        String[] postList = new String[model.length];
        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl("http://"+ LocalDatabase.ipAddress+":8081/webservice/postServerModel");
        //httpPost.setHeader("X-Parse-Application-Id", app_id);
        //httpPost.setHeader("X-Parse-REST-API-Key", asspp_key);

        String postString = "";

        try {
            for (int i = 0; i < model.length; i++) {
                postList[i] = objectMapper.writeValueAsString(model[i])+Tags.ID_TAGS.parseTag(model[i].getClass().getCanonicalName());
            }
            postString = objectMapper.writeValueAsString(postList);
        }catch(Exception e){
            System.out.println(e);
        }




        httpPost.setContent(postString);
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

