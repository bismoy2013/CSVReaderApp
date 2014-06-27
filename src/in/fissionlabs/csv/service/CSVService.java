package in.fissionlabs.csv.service;

import in.fissionlabs.csv.dao.CSVDao;
import in.fissionlabs.csv.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {

	@Autowired
	CSVDao csvDao;
	
	public String uploadCSVDetails(MultipartFile multipartFile) {
		
		List<Employee> employees = new ArrayList<Employee>();
		try {
			InputStream inputStream = multipartFile.getInputStream();
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				String employeeDetails[] = line.split(",");
				Employee employee = new Employee(employeeDetails[0], employeeDetails[1], employeeDetails[2], employeeDetails[3]);
				System.out.println(employee);
				employees.add(employee);
			}
			
			return csvDao.saveCSVDetails(employees);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
		
	}
}
