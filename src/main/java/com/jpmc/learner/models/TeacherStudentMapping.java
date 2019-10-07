package com.jpmc.learner.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity
public class TeacherStudentMapping implements Serializable  {

	private static final long serialVersionUID = -1418299487086963754L;
	
	/*
	 * @Query("select c.course_id, c.course_name,c.description,c.timing,c.start_date,c.end_date,u.user_id,u.full_name from lernerjpmc.user u join lernerjpmc.mapping m on m.student_id=u.user_id \n"
	 * + " join lernerjpmc.course c on m.course_id = c.course_id\n" +
	 * "			where m.teacher_id = ?1")
	 */
	
	@Id
	@Column(name="course_id")
	private Integer courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "description")
	private String description;
	@Column(name = "timing")
	private String timing;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "mapping_id")
	private Integer mappingId;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Integer getMappingId() {
		return mappingId;
	}
	public void setMappingId(Integer mappingId) {
		this.mappingId = mappingId;
	}
	@Override
	public String toString() {
		return "TeacherStudentMapping [courseId=" + courseId + ", courseName=" + courseName + ", description="
				+ description + ", timing=" + timing + ", startDate=" + startDate + ", endDate=" + endDate + ", userId="
				+ userId + ", fullName=" + fullName + ", mappingId=" + mappingId + "]";
	}
	

}
