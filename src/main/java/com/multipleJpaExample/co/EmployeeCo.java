package com.multipleJpaExample.co;

import com.multipleJpaExample.enums.Nationality;

/**
 * Created by Vishal Maurya on 31/10/17.
 */
public class EmployeeCo {
  private String firstName;
  private String lastName;
  private Double salary;
  private Nationality nationality;

  public String getFirstName() {
    return firstName;
  }

  public EmployeeCo setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public EmployeeCo setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Double getSalary() {
    return salary;
  }

  public EmployeeCo setSalary(Double salary) {
    this.salary = salary;
    return this;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public EmployeeCo setNationality(Nationality nationality) {
    this.nationality = nationality;
    return this;
  }
}
