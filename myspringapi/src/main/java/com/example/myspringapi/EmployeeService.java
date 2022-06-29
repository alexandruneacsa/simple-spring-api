package com.example.myspringapi;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        validateEmail(employee.getEmailAdress());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employee with id %s doesn't exist", id)));

        validateEmail(employee.getEmailAdress());

        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setAddress(employee.getAddress());
        employeeToUpdate.setAge(employee.getAge());
        employeeToUpdate.setEmailAdress(employee.getEmailAdress());
        employeeToUpdate.setRole(employee.getRole());

        employeeRepository.save(employeeToUpdate);
    }

    private void validateEmail(String email){
        Optional<Employee> employeeOptional = employeeRepository.getEmployeeByEmailAdress(email);
        if(employeeOptional.isPresent()){
            throw new IllegalStateException(String.format("Email %s already exist", email));
        }
    }

    public void deleteEmployee(Long id){
        boolean employeeExist = employeeRepository.existsById(id);
        if(!employeeExist){
            throw new IllegalStateException(String.format("Employee with is %s doesn't exist", id));
        }
        employeeRepository.deleteById(id);
    }
}
