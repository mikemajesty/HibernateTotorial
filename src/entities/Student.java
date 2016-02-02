package entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student_Information")
public class Student{

	@Id @GeneratedValue
	private int studentID;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="studentID")
	private StudentDetail detail;
	
	
	
	public StudentDetail getDetail() {
		return detail;
	}
	public void setDetail(StudentDetail detail) {
		this.detail = detail;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	//@Transient essa tag permite que a propriedade não seja mapeada pelo hibernate
	private Date birthDate;
	

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getStudentID() {

		return studentID;
	}
	public void setStudentID(int studentID) {

		this.studentID = studentID;
	}
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	@Column(name="FULL_NAME",nullable=false)
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	private StudentAddress studentAddress;
	public StudentAddress getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Set<StudentCertification> getEstudentCertification() {
		return estudentCertification;
	}
	public void setEstudentCertification(Set<StudentCertification> estudentCertification) {
		this.estudentCertification = estudentCertification;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<StudentCertification> estudentCertification = new HashSet<StudentCertification>();
	
	
}
