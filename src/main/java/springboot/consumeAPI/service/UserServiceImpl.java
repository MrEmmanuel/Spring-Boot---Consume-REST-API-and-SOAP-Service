package springboot.consumeAPI.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getRepos(String user) {
        String url = String.format("https://api.github.com/users/%s/repos", "MrEmmanuel");
        String repos = consume(url).toString();
        return repos;
    }

    @Override
    public String getCommits(String user, String repoName) {
        String url = String.format("https://api.github.com/repos/%s/%s/commits", "MrEmmanuel", "git-basic-exercises");
        String commits =  consume( url).toString();
        return commits;
    }

    public String consume(String url){
        RestTemplate restTemplate = new RestTemplate();
        String response
                = restTemplate.getForObject(url, String.class);

        System.out.println(response);

        return response;
    }


}
