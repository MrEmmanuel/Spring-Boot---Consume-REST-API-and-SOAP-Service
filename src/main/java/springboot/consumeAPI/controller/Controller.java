package springboot.consumeAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springboot.consumeAPI.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class Controller {

    @GetMapping("/")
    public String Home(){
        return "Welcome Home";
    }
    @Autowired
    UserService userService;

    @GetMapping("/list/commits")
    public ResponseEntity<String> getCommits() {
        RestTemplate template = new RestTemplate();
        String userResourceUrl = "https://api.github.com/repos/MrEmmanuel/git-basic-exercises/commits";
        ResponseEntity<String> response = template.getForEntity(userResourceUrl, String.class);
        System.out.println("response " + response);
        return response;
    }

    @GetMapping("/list/repos")
    public ResponseEntity<String> getRepos(){
        RestTemplate template = new RestTemplate();
        String userResourceUrl = "https://api.github.com/users/MrEmmanuel/repos";
        ResponseEntity<String> response = template.getForEntity(userResourceUrl, String.class);
        System.out.println("response " + response);
        return response;
    }
}
