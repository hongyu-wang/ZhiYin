package server.webclient;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.webclient.webErrors.WebRequestException;

/**
 * @author rsang
 */
public class WebServiceClient {
    private static String serverIP = "http://127.0.0.1:7001/";

    public static <E> E getServerModel(long key) throws WebRequestException{
        String url = serverIP + "webservice/getServerModel/{key}";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            return (E) restTemplate.getForObject(url, ServerModel.class, key);
        }
        catch(ClassCastException e){
            throw new WebRequestException();
        }
    }

    public static void pushServerModel(ServerModel model) throws WebRequestException{
        String url = serverIP + "webservice/putServerModel/{param}";


    }

    public static long getUserByName(String username) throws WebRequestException{
        String url = serverIP + "userservice/getUserByName/{param}";

        long key = 0;

        return key;
    }

    public static long getHashtagByName(String hashtag) throws WebRequestException{
        String url = serverIP + "hashtagservice/getHashtagByName/{param}";

        long key = 0;

        return key;
    }

    public static long getSerial() throws WebRequestException{
        String url = serverIP + "webservice/getSerial/";

        long key = 0;

        return key;
    }

    public static void main(String args[]) throws Exception {
        getServerModel(1);
    }


}
