package entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Student_Detail")
public class StudentDetail {

	@Id
	@GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator",strategy="foreign",parameters={@Parameter(value="student",name="property")})
	private int studentID;

	public int getStudentID() {
		return studentID;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentID")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private String mobile;
}
