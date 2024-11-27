package com.sambit.Service;


import com.sambit.Entity.Employee;
import com.sambit.Exception.ResourceNotFound;
import com.sambit.Repositry.EmployeeRepository;
import com.sambit.payload.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

   private EmployeeRepository employeeRepository;
   private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper)
    {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }



      public EmployeeDto addEmployee(EmployeeDto dto) {
          Employee employee = mapToEntity(dto);
          Employee emp=  employeeRepository.save(employee);
          EmployeeDto employeeDto=  mapToDto(emp);
      //    employeeDto.setDate(new Date());
             return employeeDto;
      }

    public void deleteEmployee(long id) {

      employeeRepository.deleteById(id);

    }


    public EmployeeDto UpdateEmployee(long id, EmployeeDto dto) {
         Employee employee=  mapToEntity(dto);
        Employee upadted = employeeRepository.save(employee);
      EmployeeDto employeeDto= mapToDto(upadted);
        return employeeDto;
    }

    public List<EmployeeDto> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
     Sort sort= sortDir.equalsIgnoreCase("asc") ?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> all = employeeRepository.findAll(page);
        List<Employee> employee = all.getContent();
        List<EmployeeDto> emp = employee.stream().
                map(e -> mapToDto(e)).
                collect(Collectors.toList());
        return emp;
     }

   EmployeeDto mapToDto( Employee employee){
       EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
       return dto;
    }

   Employee mapToEntity( EmployeeDto dto){
       Employee emp = modelMapper.map(dto, Employee.class);

       return emp;

    }


    public EmployeeDto getEmployeesById(long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFound("record not found with id "+ empId)
        );

           EmployeeDto dto= mapToDto(employee);
            return  dto;

    }
}





