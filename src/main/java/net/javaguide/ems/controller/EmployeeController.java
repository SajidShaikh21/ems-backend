package net.javaguide.ems.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguide.ems.dto.EmployeeDto;
import net.javaguide.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "EmployeeController",description = "To Perform Operation on Employee")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //Build Add Employee REST API
    @Operation(
            summary = "POST operation on employee",
            description = "It is used to save employee in database "
    )
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee( @RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get Employee By id REST API
    @Operation(
            summary = "GET operation on employee by id",
            description = "It is used to retrieve employee in database "
    )
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById( @PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build get All Employee REST API
    @Operation(
            summary = "GET operation on employee",
            description = "It is used to get employee in database "
    )
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.of(Optional.ofNullable(employees));
    }

   // Build Update Employee REST API
   @Operation(
           summary = "PUT operation on employee",
           description = "It is used to update employee in database "
   )
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto>updateEmployee( @PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
           return ResponseEntity.ok(employeeDto);
    }

    // Build Delete Employee Rest API
    @Operation(
            summary = "DELETE operation on employee",
            description = "It is used to delete employee in database "
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee( @PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Successfully Deleted ");
    }
}
