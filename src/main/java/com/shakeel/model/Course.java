package com.shakeel.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	private String courseName;

//	@OneToMany(targetEntity = Application.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.REFRESH, CascadeType.DETACH })
//	@JoinColumn(name = "cors_fk", referencedColumnName = "courseId")
//	private List<Application> applications = new ArrayList<>();

//	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Application.class)
//	private Application app;

	public Course() {
		super();
	}

	public Course(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
//		this.app = app;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

//	public Application getApp() {
//		return app;
//	}
//
//	public void setApp(Application app) {
//		this.app = app;
//	}

}
