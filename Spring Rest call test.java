package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResonseBody;

@RestController
public class NewsController {

  @Autowired
  private NewsService newsService;

  @GetMapping("/api/news/topstories")
  @ResonseBody
	public  News getNews() throws Exception{
	  return newsService.getTopStories();
	}
	
}

@Service
public class NewsService {
	
@Autowired
private final RestTemplate restTemplate;

public News[] getTopStories() {

  String nytimesDevURL = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=5kXcrGkN7HyDvktC1RaoTCZRjIhJsama";
  
  HttpHeaders httpHeaders = new HttpHeaders();
  httpHeaders.setContentType(MediaType.APPLICATION_JSON);
  HttpEntity httpEntity = new HttpEntity(headers);

  Map response = restTemplate.exchange(nytimesDevURL, HttpMethod.GET, httpEntity,Map.class );
  if (HttpStatus.OK() == response.getStatus()) {
    ObjectMapper objectMapper = new ObjectMapper();
    News [] topStories = objectMapper.readValue(response.getResults(), News.class);
    return topStories;
  }

  return null;
}
}