package com.multipleJpaExample.services;

import com.multipleJpaExample.co.EmployeeCo;
import com.multipleJpaExample.entities.mysql.IndianEmployees;
import com.multipleJpaExample.enums.Nationality;

import org.springframework.stereotype.Service;

/**
 * Created by Vishal Maurya on 31/10/17.
 */

public interface EmployeeService {
  Integer saveEmployee(EmployeeCo employeeCo);
  EmployeeCo getEmployee(Integer id,Nationality nationality);
}
