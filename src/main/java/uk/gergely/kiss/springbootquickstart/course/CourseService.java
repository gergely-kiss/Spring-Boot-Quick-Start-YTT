package uk.gergely.kiss.springbootquickstart.course;

import java.util.List;


public interface CourseService {
	
	public List<Course>getAllCourse(String id);

	public Course getCourse(String id);

	public String addCourse(Course course);

	public String updateCourse(Course course);

	public String deleteCourse(String id);
}
