package com.multipleJpaExample.controllers;

import com.multipleJpaExample.co.EmployeeCo;
import com.multipleJpaExample.enums.Nationality;
import com.multipleJpaExample.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Vishal Maurya on 31/10/17.
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;

  @PostMapping(value = "save",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> saveEmployee(@RequestBody EmployeeCo employeeCo){
    Integer response = employeeService.saveEmployee(employeeCo);
    return new ResponseEntity<Integer>(response, HttpStatus.OK);
  }

  @GetMapping(value = "{id}/nationality/{nationality}")
  public ResponseEntity<EmployeeCo> getEmployee(@PathVariable Integer id, @PathVariable Nationality nationality){
    EmployeeCo employeeCo = employeeService.getEmployee(id, nationality);
    return new ResponseEntity<EmployeeCo>(employeeCo,HttpStatus.OK);
  }
}
