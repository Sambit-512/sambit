package com.sambit.Controller;

import com.sambit.Entity.Employee;
import com.sambit.Service.EmployeeService;
import com.sambit.payload.EmployeeDto;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/add")
    public ResponseEntity<?>  addEmployee
            (
                    @Valid @RequestBody EmployeeDto dto,
                  BindingResult result
                    )
    {
        System.out.println("100");
        if (result.hasErrors()){
           return  new  ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.NOT_FOUND);
        }
      EmployeeDto employeeDto=employeeService.addEmployee(dto);
      return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

   @DeleteMapping
    public ResponseEntity<String> deleteByEmployee(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("delete",HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<EmployeeDto> UpdateEmployee
            (@RequestParam long id,
             @RequestBody EmployeeDto dto
            ){
        EmployeeDto employeeDto = employeeService.UpdateEmployee(id, dto);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(
            @RequestParam(name = "pageNo" ,required = false,defaultValue = "0") int pageNo,
            @RequestParam(name="pageSize", required = false,defaultValue = "5") int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "asc") String sortDir
    ){
      List<EmployeeDto> employeeDto=  employeeService.findAll( pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(employeeDto ,HttpStatus.OK);
    }

    @GetMapping("/employeeId/{empId}")
      public ResponseEntity<EmployeeDto> getEmployeesById(
              @PathVariable long empId
      ){
        EmployeeDto employeeDto = employeeService.getEmployeesById(empId);
             return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    }


