package com.multipleJpaExample.repositories.mysql;

import com.multipleJpaExample.entities.mysql.IndianEmployees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vishal Maurya on 31/10/17.
 */
@Repository
public interface IndianEmployeeRepository extends JpaRepository<IndianEmployees,Integer> {
}
