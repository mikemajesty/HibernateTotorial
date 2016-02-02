package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Certification")
public class StudentCertification {

	@Id
	@GeneratedValue
	private int studentCertificationID;
	private String  studentCertificationName;
	
	public String getStudentCertificationName() {
		return studentCertificationName;
	}
	public void setStudentCertificationName(String studentCertificationName) {
		this.studentCertificationName = studentCertificationName;
	}
	public int getStudentCertificationID() {
		return studentCertificationID;
	}
	public void setStudentCertificationID(int studentCertificationID) {
		this.studentCertificationID = studentCertificationID;
	}
	
}
