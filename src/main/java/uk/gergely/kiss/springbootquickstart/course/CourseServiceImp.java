package uk.gergely.kiss.springbootquickstart.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	CourseRepositoryService courseRepositoryService;

	@Override
	public List<Course> getAllCourse(String topicId) {
		List<Course> topicList = new ArrayList<>();
		courseRepositoryService.findByTopicId(topicId).forEach(topicList::add);
		return topicList;
	}

	@Override
	public Course getCourse(String id) {
		return courseRepositoryService.findOne(id);
	}

	@Override
	public String addCourse(Course topic) {
		
		return courseRepositoryService.save(topic).toString() + " saved";
	}

	@Override
	public String updateCourse(Course topic) {
		return "Course updated: " + courseRepositoryService.save(topic).toString();
	}
	@Override
	public String deleteCourse(String id) {
		courseRepositoryService.delete(id);
		return "Course removed by id: " +id;

	}
}
