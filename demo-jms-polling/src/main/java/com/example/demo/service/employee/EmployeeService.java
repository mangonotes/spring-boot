package com.example.demo.service.employee;

import com.example.demo.dao.entity.EmployeeEntity;
import com.example.demo.dao.repository.EmployeeRespository;
import com.example.demo.ui.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements  IEmployeeService {

    private final EmployeeRespository employeeRespository;
    @Autowired
    public EmployeeService(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public void insert(EmployeeDTO employeeDto) {
        employeeRespository.save(convert.apply(employeeDto));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
       return  employeeRespository.findAll().stream().map(this::inverseConverter).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        return null;
    }
    private Function<EmployeeDTO,EmployeeEntity> convert= (EmployeeDTO employeeDTO) ->
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setDesignation(employeeDTO.getDesignation());
        employeeEntity.setDoj(employeeDTO.getDoj());
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setNatinality(employeeDTO.getNationality());
        return employeeEntity;
    };
    private EmployeeDTO inverseConverter(EmployeeEntity employeeEntity)
    {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDesignation(employeeEntity.getDesignation());
        employeeDTO.setDoj(employeeEntity.getDoj());
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setNationality(employeeEntity.getNatinality());
        employeeDTO.setId(employeeEntity.getId());
        return employeeDTO;
    }
}
