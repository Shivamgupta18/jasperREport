package com.jasper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name ="Employee_TBL")
public class Employee {
    @Id
	private Integer id;
	private String name;
	private String designation;
	private String salary;
	private String dob;
	
}
