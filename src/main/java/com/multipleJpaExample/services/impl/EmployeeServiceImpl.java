package com.multipleJpaExample.services.impl;

import com.multipleJpaExample.co.EmployeeCo;
import com.multipleJpaExample.entities.mysql.IndianEmployees;
import com.multipleJpaExample.entities.postgres.AmericanEmployees;
import com.multipleJpaExample.enums.Nationality;
import com.multipleJpaExample.repositories.mysql.IndianEmployeeRepository;
import com.multipleJpaExample.repositories.postgres.AmericanEmployeeRepo;
import com.multipleJpaExample.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vishal Maurya on 31/10/17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  IndianEmployeeRepository indianEmployeeRepository;

  @Autowired
  AmericanEmployeeRepo americanEmployeeRepo;

  public Integer saveEmployee(EmployeeCo employeeCo) {
    switch (employeeCo.getNationality()){
      case INDIAN: {
        return saveIndianEmployee(employeeCo);
      }
      case AMERICAN: {
        return saveAmericanEmployee(employeeCo);
      }
      default: return null;
    }

  }

  public EmployeeCo getEmployee(Integer id, Nationality nationality) {
    switch (nationality){
      case INDIAN: {
        return getIndianEmployee(id);
      }
      case AMERICAN: {
        return getAmericanEmployee(id);
      }
      default: return null;
    }
  }

  private Integer saveIndianEmployee(EmployeeCo employeeCo){
    IndianEmployees indianEmployees = new IndianEmployees();
    indianEmployees.setFirstName(employeeCo.getFirstName())
            .setLastName(employeeCo.getLastName())
            .setSalary(employeeCo.getSalary());
    return indianEmployeeRepository.save(indianEmployees).getId();
  }

  private Integer saveAmericanEmployee(EmployeeCo employeeCo){
    AmericanEmployees americanEmployees = new AmericanEmployees();
    americanEmployees.setFirstName(employeeCo.getFirstName())
            .setLastName(employeeCo.getLastName())
            .setSalary(employeeCo.getSalary());
    return americanEmployeeRepo.save(americanEmployees).getId();
  }

  private EmployeeCo getAmericanEmployee(Integer id){
    AmericanEmployees americanEmployees= americanEmployeeRepo.findOne(id);
    EmployeeCo employeeCo = new EmployeeCo();
    employeeCo.setFirstName(americanEmployees.getFirstName())
            .setLastName(americanEmployees.getLastName())
            .setSalary(americanEmployees.getSalary())
            .setNationality(Nationality.AMERICAN);
    return employeeCo;
  }

  private EmployeeCo getIndianEmployee(Integer id){
    IndianEmployees indianEmployees= indianEmployeeRepository.findOne(id);
    EmployeeCo employeeCo = new EmployeeCo();
    employeeCo.setFirstName(indianEmployees.getFirstName())
            .setLastName(indianEmployees.getLastName())
            .setSalary(indianEmployees.getSalary())
            .setNationality(Nationality.INDIAN);
    return employeeCo;
  }
}
