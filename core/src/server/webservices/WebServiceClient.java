package server.webservices;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import server.model.user.UserProfile;

/**
 * @author rsang
 */
public class WebServiceClient {

    public static UserProfile getUserProfile(long key) {
        String url = "http://127.0.0.1:7001/userservice/getUser/{key}";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return restTemplate.getForObject(url, UserProfile.class, 1L);

    }

    public static void main(String args[]) throws Exception {
        getUserProfile(1);
    }


}
