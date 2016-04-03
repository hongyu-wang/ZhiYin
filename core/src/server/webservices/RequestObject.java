package server.webservices;

import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.structureModels.ServerModel;
import tools.serverTools.generators.Tags;


/**
 * A singleton used to request models from the server
 */
public class RequestObject implements Net.HttpResponseListener {
    private LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
    private JsonReader reader = new JsonReader();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Object rOjbect;

    public static RequestObject newInstance(){
        return new RequestObject();

    }

    /**
     * Retrieves a model from the server
     *
     * @param key       id key of the model
     */
    public void getModel(long key) {
        // LibGDX NET CLASS
        Net.HttpRequest httpGet = new Net.HttpRequest(Net.HttpMethods.GET);
        httpGet.setUrl("http://"+ LocalDatabase.ipAddress+":8081/webservice/getServerModel/" + key);
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
            String json = httpResponse.getResultAsString();
            int tag = Integer.parseInt(json.substring(json.length()-4));
//            System.out.println(tag+1);
            String className = Tags.ID_TAGS.getName(tag);
//            System.out.println(className);
            json = json.substring(0, json.length()-4);
            rOjbect = objectMapper.readValue(json, Class.forName(className));
            localDatabase.setModelFromServer((ServerModel)rOjbect);
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
