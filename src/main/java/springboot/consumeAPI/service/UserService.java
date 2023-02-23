package springboot.consumeAPI.service;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> getCommits();
    ResponseEntity<String>  getRepos();

}
