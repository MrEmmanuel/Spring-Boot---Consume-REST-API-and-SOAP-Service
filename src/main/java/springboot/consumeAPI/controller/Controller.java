package springboot.consumeAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.consumeAPI.service.UserService;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    UserService userService;

    @GetMapping("/repos")
    public ResponseEntity<String> getRepos(String user)
    {
        return new ResponseEntity<String>(userService.getRepos(user), HttpStatus.OK);
    }

    @GetMapping("/commits")
    public ResponseEntity<String> getCommits(String user, String repoName)
    {
        return new ResponseEntity<String>(userService.getCommits(user,repoName), HttpStatus.OK);
    }
}
