package com.multipleJpaExample.entities.postgres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Vishal Maurya on 1/11/17.
 */
@Entity
public class AmericanEmployees {
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

  public AmericanEmployees setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public AmericanEmployees setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public AmericanEmployees setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Double getSalary() {
    return salary;
  }

  public AmericanEmployees setSalary(Double salary) {
    this.salary = salary;
    return this;
  }
}
