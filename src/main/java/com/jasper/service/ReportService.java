package com.jasper.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jasper.entity.Employee;
import com.jasper.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

@Service
public class ReportService {

	@Autowired
	private EmployeeRepository repository;
	String path="/Users/shivamgupta/Desktop";
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
	List<Employee> employees=repository.findAll();
	
	File file=ResourceUtils.getFile("classpath:employee.jrxml");
	
	JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
	JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(employees);
	Map<String, Object> parameters=new HashMap<>();
	parameters.put("Created By", "Java Techie");
	JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameters,datasource);
	 if(reportFormat.equalsIgnoreCase("html")) {
		  JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"/employee.html");
	 }
	 if(reportFormat.equalsIgnoreCase("pdf")) {
	 JasperExportManager.exportReportToPdfFile(jasperPrint,path+"/employee.pdf");	 
	 }
	return "report generated in path" + path;
	}
}
