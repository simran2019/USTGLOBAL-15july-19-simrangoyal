package com.dev.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.springrest.dao.EmployeeDao;
import com.dev.springrest.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public boolean addEmployee(Employee employee) {
		
		return dao.addEmployee(employee);
	}

	@Override
	public boolean removeEmployee(int id) {
		
		return dao.removeEmployee(id);
	}

	@Override
	public boolean modifyEmployee(Employee employee) {
	
		return dao.modifyEmployee(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		
		return dao.getEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return dao.getAllEmployee();
	}

}
