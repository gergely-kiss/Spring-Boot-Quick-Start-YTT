package uk.gergely.kiss.springbootquickstart.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicsService topicsService;
	
	//by default it is @GET
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return topicsService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicsService.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		return topicsService.addTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/")
	public String updateTopic(@RequestBody Topic topic) {
		return topicsService.updateTopic(topic);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public String deleteTopic(@PathVariable("id") String id) {
		return topicsService.deleteTopic(id);
	}
	
}
