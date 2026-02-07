package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> findByLastname(@Param("LASTNAME") String lastname);

    @Query
    List<Employee> findFromLastname(@Param("VALUE") String lastname);

    @Query
    List<Employee> findFromFirstname(@Param("VALUE") String firstname);

    @Query
    List<Employee> findEmployeeFromId(@Param("VALUE") long id);
}
