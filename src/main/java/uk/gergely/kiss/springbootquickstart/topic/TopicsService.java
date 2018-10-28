package uk.gergely.kiss.springbootquickstart.topic;

import java.util.List;


public interface TopicsService {
	
	public List<Topic>getAllTopics();

	public Topic getTopic(String id);

	public String addTopic(Topic topic);

	public String updateTopic(Topic topic);

	public String deleteTopic(String id);
}
