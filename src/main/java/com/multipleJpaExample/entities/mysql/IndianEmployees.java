package com.multipleJpaExample.entities.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Vishal Maurya on 31/10/17.
 */
@Entity
public class IndianEmployees {
  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private Double salary;

  public Integer getId() {
    return id;
  }

  public IndianEmployees setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public IndianEmployees setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public IndianEmployees setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Double getSalary() {
    return salary;
  }

  public IndianEmployees setSalary(Double salary) {
    this.salary = salary;
    return this;
  }
}
