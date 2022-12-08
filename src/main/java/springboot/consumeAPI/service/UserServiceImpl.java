package springboot.consumeAPI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserService {

    @GetMapping("/listRepos")
    public ResponseEntity<String> getRepos(){
        RestTemplate template = new RestTemplate();
        String userResourceUrl = "https://api.github.com/users/MrEmmanuel/repos";
        ResponseEntity<String> response = template.getForEntity(userResourceUrl, String.class);
        System.out.println("response " + response);
        return response;
    }
    @GetMapping("/list/commits")
    public ResponseEntity<String> getCommits() {
        RestTemplate template = new RestTemplate();
        String userResourceUrl = "https://api.github.com/repos/MrEmmanuel/git-basic-exercises/commits";
        ResponseEntity<String> output = template.getForEntity(userResourceUrl, String.class);
        System.out.println("response " + output);
        return output;

    }
}
