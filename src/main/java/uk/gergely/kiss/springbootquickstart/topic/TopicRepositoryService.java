package uk.gergely.kiss.springbootquickstart.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepositoryService extends CrudRepository<Topic, String>{ 

}
