package net.skhu.dto;

public class Register {
	
	int id;
	String userId;
	String year;
	String semester;
	String courseCode;
	String courseName;
	String completeDivision;
	String unit;
	String credit;
	
	public Register(int id, String userId, String year, String semester, String courseCode, String courseName, String completeDivision,
			String unit, String credit) {
		this.id = id;
		this.userId = userId;
		this.year = year;
		this.semester = semester;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.completeDivision = completeDivision;
		this.unit = unit;
		this.credit = credit;
	}

	public Register(String userId, String year, String semester, String courseCode, String courseName, String completeDivision,
			String unit, String credit) {
		this.userId = userId;
		this.year = year;
		this.semester = semester;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.completeDivision = completeDivision;
		this.unit = unit;
		this.credit = credit;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getSemester() {
		return semester;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCompleteDivision() {
		return completeDivision;
	}
	
	public void setCompleteDivision(String completeDivision) {
		this.completeDivision = completeDivision;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getCredit() {
		return credit;
	}
	
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
}
