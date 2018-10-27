package uk.gergely.kiss.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicsServiceImp implements TopicsService {

	private List<Topic> topicList;

	public TopicsServiceImp() {
		super();
		init();
	}

	@Override
	public List<Topic> getAllTopics() {
		return topicList;
	}

	@Override
	public Topic getTopic(String id) {
		return topicList.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	@Override
	public String addTopic(Topic topic) {
		try {
			topicList.add(topic);
			return "Topic saved: " + topic.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String updateTopic(String id, Topic topic) {
		
		topicList.set(topicList.indexOf(getTopic(id)), topic);
		return "Topic updated: " + topic.toString();
	}
	@Override
	public String deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
		return "Topic removed by id: " +id;

	}
	////////////////////////////////////////////////////////////////////
	private void init() {
		topicList = new ArrayList<>();
		topicList.add(new Topic("spring", "Spring Framework", "Spring Framework Description"));
		topicList.add(new Topic("java", "Core Java", "Core Java Description"));
		topicList.add(new Topic("javascript", "JavaScript", "JavaScript Framework Description"));
	}

	


}
