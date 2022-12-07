package springboot.consumeAPI.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getRepos(String user) {
        String url = String.format("https://api.github.com/users/%s/repos", "MrEmmanuel");
        String repos = consume(url, "name");
        return repos;
    }

    @Override
    public String getCommits(String user, String repoName) {
        String url = String.format("https://api.github.com/repos/%s/%s/commits", "MrEmmanuel", "git-basic-exercises");
        String commits =  consume( url, "message");
        return commits;
    }

    public String consume(String url, String string){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept","application/vnd.github+json");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JSONArray jsonArray = new JSONArray(response.getBody());
        String key = string.toLowerCase();

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(key.equals("name")) {
                System.out.println(jsonObject.getString("name"));
            }else{
                System.out.println(jsonObject.getJSONObject("commit").getString("message"));
            }
        }
        return response.toString();
    }
}
