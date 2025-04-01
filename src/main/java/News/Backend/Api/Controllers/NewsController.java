package News.Backend.Api.Controllers;

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
	
//	String api_Keys[] = {
//			"2-rOj8u_H5Ku5dZTSaI7QlxVNwmxzMtRudKQzF5IULNYAA5r",
//			"03FtBRp58cqjxXbQeuFymPSj0Qjm5maGM8zZKKWUG037TNon"
//	};
	String api_Key = "jWR3FV3lxi2cn5mwWgH8QcrUMX3dFRbdu4IaxcHE6ewYpOeJ";
	
	@GetMapping("/getNews")
	public ResponseEntity<?> getNews() {
		String uri = "https://api.currentsapi.services/v1/latest-news?apiKey="+api_Key;
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(uri, String.class);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getNews/category/{category}")
	public ResponseEntity<?> getNewsByCategory(@PathVariable String category) {
		String uri = "https://api.currentsapi.services/v1/latest-news?"+"apiKey="+api_Key+"&category=" + category+"&page_size=50";
		System.out.println("Category");
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(uri, String.class);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getNews/keyword/{keyword}")
	public ResponseEntity<?> getNewsByKeyword(@PathVariable String keyword) {
		String uri = "https://api.currentsapi.services/v1/search?keywords="+keyword+"&apiKey="+api_Key;
		System.out.println("keyword");
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(uri, String.class);
		return ResponseEntity.ok(response);
	}
	
}
