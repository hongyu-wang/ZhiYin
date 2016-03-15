package server.webservices;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import server.model.structureModels.ServerModel;
import server.webservices.webErrors.WebRequestException;

/**
 * @author rsang
 */
public class WebServiceClient {

    public static <E> E getServerModel(long key) throws WebRequestException{
        String url = "http://127.0.0.1:7001/userservice/getServerModel/{key}";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            return (E) restTemplate.getForObject(url, ServerModel.class, key);
        }
        catch(ClassCastException e){
            throw new WebRequestException();
        }
    }

    public static void main(String args[]) throws Exception {
        getServerModel(1);
    }


}
