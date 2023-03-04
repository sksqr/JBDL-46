package com.example.L09SpringJPAdemo;

import com.example.L09SpringJPAdemo.entity.Employee;
import com.example.L09SpringJPAdemo.repo.IEmployeeRepo;
import com.example.L09SpringJPAdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.createEmp(employee));
    }

    @PostMapping("/detail")
    public ResponseEntity<EmployeeDetailDTO> createEmp(@RequestBody EmployeeDetailDTO employeeDetailDTO){
        return ResponseEntity.ok(employeeService.createEmpDatail(employeeDetailDTO));
    }

    @GetMapping("/byname")
    public  ResponseEntity<List<Employee>> getByName(@RequestParam String name){
        return ResponseEntity.ok(employeeService.getByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeRepo.findById(id).get();
        return ResponseEntity.ok(employee);
    }

}
