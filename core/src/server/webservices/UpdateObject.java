package server.webservices;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.structureModels.ServerModel;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import tools.serverTools.generators.Tags;

import java.util.List;


/**
 * A singleton used to request models from the server
 */
public class UpdateObject implements Net.HttpResponseListener {
    private LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
    private JsonReader reader = new JsonReader();
    private ObjectMapper objectMapper = new ObjectMapper();

    public static UpdateObject newInstance(){
        return new UpdateObject();

    }

    /**
     * Retrieves a model from the server
     *
     */
    public void update(Long[] alreadyUpdated) {
        // LibGDX NET CLASS
        Net.HttpRequest httpGet = new Net.HttpRequest(Net.HttpMethods.GET);
        httpGet.setUrl("http://"+ LocalDatabase.ipAddress+":8081/webservice/update/"+alreadyUpdated);
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
            List rOjbect = objectMapper.readValue(json, List.class);
            for(Object r : rOjbect) {
                localDatabase.setModelFromServer((ServerModel) r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void failed(Throwable t) {
        System.out.println(t.getMessage());
    }
}
