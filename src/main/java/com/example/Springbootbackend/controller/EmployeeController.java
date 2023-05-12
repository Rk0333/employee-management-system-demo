package com.example.Springbootbackend.controller;

import com.example.Springbootbackend.exception.ResourceNotFound;
import com.example.Springbootbackend.model.Employee;
import com.example.Springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

        @PostMapping
        public Employee createEmployee(@RequestBody Employee employee){
            return employeeRepository.save(employee);
        }


        //Rest api to get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);

    }
        //Rest API to update employee

        @PutMapping("{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeedetails){

        Employee updateEmployee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee does not exist with id"+id));

        updateEmployee.setFirstname(employeedetails.getFirstname());
        updateEmployee.setLastname(employeedetails.getLastname());
        updateEmployee.setEmailid(employeedetails.getEmailid());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

        }


        //Rest API to Delete a employee

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFound("Employee does not exist with id:"+id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
