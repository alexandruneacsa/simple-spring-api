package com.example.myspringapi;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> getEmployees();
    void createEmployee(Employee employee);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
