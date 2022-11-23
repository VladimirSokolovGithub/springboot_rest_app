package com.vladimirsokolov.spring.springboot.springboot_rest_app.service;

import com.vladimirsokolov.spring.springboot.springboot_rest_app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
