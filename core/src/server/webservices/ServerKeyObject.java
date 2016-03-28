package server.webservices;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.structureModels.ServerModel;

/**
 * Created by Hairuo on 2016-03-23.
 */
public class ServerKeyObject implements Net.HttpResponseListener {
    private ModelStorage modelStorage;
    private Object rOjbect;

    private int runMax = 100000000;

    public ServerKeyObject(ModelStorage modelStorage){
        this.modelStorage = modelStorage;
    }

    public static ServerKeyObject getInstance(ModelStorage modelStorage){
        return new ServerKeyObject(modelStorage);
    }


    /**
     * Retrieves a model from the server
     *
     */
    public void getKey() {
        // LibGDX NET CLASS
        Net.HttpRequest httpGet = new Net.HttpRequest(Net.HttpMethods.GET);
        httpGet.setUrl("http://localhost:8081/webservice/getServerKey");
        httpGet.setTimeOut(runMax);
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
            modelStorage.putGeneratedKey(key);
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
