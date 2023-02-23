package springboot.consumeAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springboot.consumeAPI.service.UserService;
import springboot.consumeAPI.wsdl.CountriesPortService;
import springboot.consumeAPI.wsdl.Country;
import springboot.consumeAPI.wsdl.GetCountryRequest;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/api")
public class Controller {

    private final UserService userService;
    @GetMapping("/")
    public String home(){
        return "Welcome Home";
    }

    @Autowired
    public Controller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list/commits")
    public ResponseEntity<String> getCommits() {
        RestTemplate template = new RestTemplate();
        String userResourceUrl = "https://api.github.com/repos/MrEmmanuel/git-basic-exercises/commits";
        ResponseEntity<String> response = template.getForEntity(userResourceUrl, String.class);
        System.out.println("response " + response.getBody());
        return response;
    }

    @GetMapping("/list/repos")
    public ResponseEntity<String> getRepos(){
        RestTemplate template = new RestTemplate();
        String userResourceUrl = "https://api.github.com/users/MrEmmanuel/repos";
        ResponseEntity<String> response = template.getForEntity(userResourceUrl, String.class);
        System.out.println("response " + response.getBody());
        return response;
    }

    @GetMapping("get/country")
    public Object getCountry() throws MalformedURLException, JsonProcessingException {
        URL url = new URL("http://localhost:9090/ws/countries.wsdl");
        CountriesPortService countriesPortService = new CountriesPortService(url);

        GetCountryRequest request = new GetCountryRequest();
        request.setName("United Kingdom");

        Country country = countriesPortService.getCountriesPortSoap11().getCountry(request).getCountry();
        JSONObject response = new JSONObject(country);
        response.remove("name");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.toString(),Object.class);
    }
}
