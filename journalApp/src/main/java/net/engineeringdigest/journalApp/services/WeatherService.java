package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${Weather.api}")
    private String API;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city)
    {
        String finalApi = API.replace("CITY" , city).replace("API_KEY" , apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
    //Only for understand purpose. We can't call POST request in weather api.
    /*public WeatherResponse postCall(String city)
    {
        String finalApi = API.replace("CITY" , city).replace("API_KEY" , apiKey);

        //we can send headers in httpEntity;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Key" , "Value");
        // we can also send an object in httpEntity.

        String requestBody = "{\n" +
                "    \"userName\": \"testuser1\",\n" +
                "    \"password\": \"testpass1\"\n" +
                "}";
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody , httpHeaders);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.POST, httpEntity, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }*/

}
