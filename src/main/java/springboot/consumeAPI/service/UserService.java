package springboot.consumeAPI.service;

public interface UserService {

    String getCommits(String repoName, String userName);
    String getRepos(String userName);

}
