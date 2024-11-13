package com.jasper;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.entity.Employee;
import com.jasper.repository.EmployeeRepository;
import com.jasper.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
@RestController
public class JasperProjectApplication {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ReportService reportService;
	
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee(){
		return repository.findAll();
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return reportService.exportReport(format);
		 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JasperProjectApplication.class, args);
		
		
	}

}
