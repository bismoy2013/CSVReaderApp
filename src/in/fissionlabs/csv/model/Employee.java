package in.fissionlabs.csv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FISSION_EMPLOYEES")
public class Employee {

	@Id
	@Column(name = "ID")
	@GenericGenerator(name="MyGenerator",strategy="increment")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MyGenerator")
	private Integer id;
	
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;
	
	@Column(name= "EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name= "EMPLOYEE_DESIGNATION")
	private String employeeDesignation;
	
	@Column(name= "CONTACT_NUMBER")
	private String contactNumber;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeId, String employeeName,
			String employeeDesignation, String contactNumber) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.contactNumber = contactNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeeDesignation=" + employeeDesignation
				+ ", contactNumber=" + contactNumber + "]";
	}
	
}
