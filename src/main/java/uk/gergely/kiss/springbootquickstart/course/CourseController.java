package uk.gergely.kiss.springbootquickstart.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uk.gergely.kiss.springbootquickstart.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	// by default it is @GET
	@RequestMapping("/topics/{topicId}/course")
	public List<Course> getAllCourse(@PathVariable("topicId") String topicId) {
		return courseService.getAllCourse(topicId);
	}

	@RequestMapping("/topics/{topicId}/course/{id}")
	public Course getCourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
	public String addCourse(@PathVariable("topicId") String topicId,@RequestBody Course course) {
		course.setTopic(new Topic(topicId));
		return courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/")
	public String updateCourse(@PathVariable("topicId")String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId));
		return courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}//course/{id}")
	public String deleteCourse(@PathVariable("id") String id) {
		return courseService.deleteCourse(id);
	}

}
