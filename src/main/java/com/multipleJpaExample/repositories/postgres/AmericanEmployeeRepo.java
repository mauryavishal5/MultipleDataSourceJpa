package com.multipleJpaExample.repositories.postgres;

import com.multipleJpaExample.entities.postgres.AmericanEmployees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vishal Maurya on 1/11/17.
 */
@Repository
public interface AmericanEmployeeRepo extends JpaRepository<AmericanEmployees,Integer> {
}
