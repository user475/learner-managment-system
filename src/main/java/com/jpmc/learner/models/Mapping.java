package com.jpmc.learner.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Mapping", schema ="lernerjpmc")
@Component
@Scope("prototype")
public class Mapping implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2869475968234441242L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mappingId;
	private Integer studentId;
	private Integer teacherId;
	private Integer courseId;
	//@Column(columnDefinition = "boolean default 0")
	private boolean isAccepted;
	
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Integer getMappingId() {
		return mappingId;
	}
	public void setMappingId(Integer mappingId) {
		this.mappingId = mappingId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "Mapping [mappingId=" + mappingId + ", studentId=" + studentId + ", teacherId=" + teacherId
				+ ", courseId=" + courseId + ", isAccepted=" + isAccepted + "]";
	}
	
	
}
