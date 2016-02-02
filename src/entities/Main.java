package entities;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) {

		try {
			Student student = new Student();
			StudentAddress studentAddress = new StudentAddress();
			
			StudentCertification certification =new StudentCertification();
			certification.setStudentCertificationName("Java Oracle");
			
			(student.getEstudentCertification()).add(certification);
			
			studentAddress.setAddress("Ibiúna");
			
			student.setName("Mike Lima");
			student.setBirthDate(new Date(1000000000));
			StudentDetail studentDetail = new StudentDetail();
			studentDetail.setMobile("15 997624783");			
			studentDetail.setStudent(student);
			
			
			student.setDetail(studentDetail);

			student.setStudentAddress(studentAddress);
			
			
			(studentAddress.getStudent()).add(student);
			
			
			
			SessionFactory factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			session.save(studentAddress);

			Student student2 = (Student)session.get(Student.class, 1) ;
			
			System.out.print("\n\n"+student2.getName()+"\n\n\n");
			
			student2.setName("Mike Loco");
			
			session.update(student2);
			
			//session.delete(student2);
			
			
			session.getTransaction().commit();

			session.close();

			
			factory.close();
		} catch (HibernateException e) {
			System.out.print(e.getMessage());
		}
	}

}
