package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_tab")
public class Employee {

	@Id
	@Column(name="emp_id_col")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="emp_ename_col")
	private String ename;
	
	@Column(name="emp_email_col")
	private String email;
	
	@Column(name="emp_gender_col")
	private String gender;
	
	@Column(name="emp_eaddr_col")
	private String eaddr;
	
	@ElementCollection
	@CollectionTable(name= "emp_prjs_tab",joinColumns = @JoinColumn(name="emp_id_col"))
	@Column(name="emp_prjs_col")
	private List<String> prjs;
	
	@ElementCollection
	@CollectionTable(name="emp_slots_tab",joinColumns = @JoinColumn(name="emp_id_col"))
	@Column(name="emp_slots_col")
	private List<String> slots;
}
