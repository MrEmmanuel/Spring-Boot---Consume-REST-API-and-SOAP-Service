package springboot.consumeAPI.service;

import com.fasterxml.jackson.databind.JsonNode;

public class UserServiceImpl implements UserService {

    @Override
    public String getRepos(String userName) {
        return consumeRESTAPI(String.format("https://api.github.com/users/%s/repos",
                userName), "name").toString();
    }

    @Override
    public String getCommits(String userName, String repoName) {
        return consumeRESTAPI(String.format("https://api.github.com/repos/%s/%s/commits",
                userName, repoName),"message").toString();
    }

    public JsonNode consumeRESTAPI(String url, String path){

        return null;
    }


}
