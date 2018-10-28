package uk.gergely.kiss.springbootquickstart.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepositoryService extends CrudRepository<Course, String>{ 
	
	public List<Course> findByTopicId(String topicId);

}
