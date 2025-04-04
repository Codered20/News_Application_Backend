package News.Backend.Api.Controllers;

import java.util.*;

import org.springframework.http.HttpStatus;

//import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//
//import News.Backend.Api.Model.News;

@RestController
@CrossOrigin
public class NewsController {
	
	String api_Keys[] = {
			"jWR3FV3lxi2cn5mwWgH8QcrUMX3dFRbdu4IaxcHE6ewYpOeJ",
			"2-rOj8u_H5Ku5dZTSaI7QlxVNwmxzMtRudKQzF5IULNYAA5r",
			"03FtBRp58cqjxXbQeuFymPSj0Qjm5maGM8zZKKWUG037TNon",
			
	};
	
	@GetMapping("/getNews")
	public ResponseEntity<?> getNews() {
		ResponseEntity<String> response = null;
		for(String apiKey:api_Keys) {
			try {
				String uri = "https://api.currentsapi.services/v1/latest-news?apiKey="+apiKey;
				RestTemplate rest = new RestTemplate();
				response = rest.getForEntity(uri, String.class);
				if(response.getStatusCode()== HttpStatus.OK) {
					break;
				}
				System.out.println(response.getStatusCode());
			}catch(Exception ex){
				System.out.println(apiKey);
				System.out.println(response);
			}
		}
		return ResponseEntity.ok(response.getBody());
	}
	
	@GetMapping("/getNews/category/{category}")
	public ResponseEntity<?> getNewsByCategory(@PathVariable String category) {
		ResponseEntity<String> response = null;
		for(String apiKey:api_Keys) {
			try {
				String uri = "https://api.currentsapi.services/v1/latest-news?"+"apiKey="+apiKey+"&category=" + category+"&page_size=50";
				RestTemplate rest = new RestTemplate();
				response = rest.getForEntity(uri, String.class);
				if(response.getStatusCode()== HttpStatus.OK) {
					break;
				}
				System.out.println(response.getStatusCode());
			}catch(Exception ex){
				System.out.println("Limit Reached for "+apiKey);
				System.out.println(response);
			}
		}
		return ResponseEntity.ok(response.getBody());
	}
	
	@GetMapping("/getNews/keyword/{keyword}")
	public ResponseEntity<?> getNewsByKeyword(@PathVariable String keyword) {
		String keys[] = {"3049b29cd5df779b9348285646be9d39",
		                 "30f6c4f735bc87cbdb4ebf721128c4f9"};
		ResponseEntity<String> response = null;
		Map<String, Object> wrapper = null;
		for(String key:keys) {
			try {
				String uri = "http://api.mediastack.com/v1/news"
						+ "?access_key="+key
						+ "&keywords="+keyword;
				System.out.println("keyword");
				RestTemplate rest = new RestTemplate();
				response = rest.getForEntity(uri, String.class);
				if(response.getStatusCode()==HttpStatus.OK) {
					wrapper = new HashMap<>();
				    wrapper.put("news", response.getBody());
				    wrapper.put("status", "ok");
				    break;
				}
			}catch(Exception ex) {
				System.out.println("Limit reached for "+key);
			}
			
		}
		return ResponseEntity.ok(wrapper);
	}
	
}
