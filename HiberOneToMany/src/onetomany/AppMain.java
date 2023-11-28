package onetomany;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cache.cfg.*;
import org.hibernate.cfg.Configuration;


public class AppMain {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("Hiber.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
	/*	Department department= new Department();
		department.setDeptcode(12);
		department.setDeptname("electronics");
		
		Employee employee1=new Employee();
		employee1.setEmpid(103);
		employee1.setEmpname("Rakesh");
		employee1.setSalary(30000);
		employee1.setDeptobj(department);
		
		Employee employee2=new Employee();
		employee2.setEmpid(104);
		employee2.setEmpname("Bharath");
		employee2.setSalary(45000);
		employee2.setDeptobj(department);
		
		Set<Employee> empset = new HashSet<Employee>();
		empset.add(employee1);
		empset.add(employee2);
		department.setEmplist(empset);
		session.save(department);
		
		session.getTransaction().commit();
		*/
		session.close();
		System.out.println("Retriving Data");
		session=sf.openSession();
		Department dobj=session.find(Department.class,11);
		Set<Employee> eset=dobj.getEmplist();
		for(Employee e:eset) {
			System.out.println("employee name is "+e.getEmpname());
			System.out.println("employee salary is "+e.getSalary());
		}
	}

}
