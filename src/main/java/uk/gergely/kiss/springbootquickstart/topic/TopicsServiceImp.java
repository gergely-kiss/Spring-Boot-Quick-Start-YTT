package uk.gergely.kiss.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicsServiceImp implements TopicsService {

	@Autowired
	TopicRepositoryService topicRepositoryService;

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topicList = new ArrayList<>();
		topicRepositoryService.findAll().forEach(topicList::add);
		return topicList;
	}

	@Override
	public Topic getTopic(String id) {
		return topicRepositoryService.findOne(id);
	}

	@Override
	public String addTopic(Topic topic) {
		
		return topicRepositoryService.save(topic).toString() + " saved";
	}

	@Override
	public String updateTopic(Topic topic) {
		return "Topic updated: " + topicRepositoryService.save(topic).toString();
	}
	@Override
	public String deleteTopic(String id) {
		topicRepositoryService.delete(id);
		return "Topic removed by id: " +id;

	}
}
