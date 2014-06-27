package in.fissionlabs.csv.dao;

import java.util.List;

import in.fissionlabs.csv.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CSVDao {


	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public String saveCSVDetails(List<Employee> employees) {
		
		for(Employee employee : employees) {
			hibernateTemplate.save(employee);
		}
		return "Details to Database";
	
	}
}
