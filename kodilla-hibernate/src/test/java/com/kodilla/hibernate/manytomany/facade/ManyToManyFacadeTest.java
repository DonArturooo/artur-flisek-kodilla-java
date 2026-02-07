package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManyToManyFacadeTest {
    @Autowired
    private  CompanyDao companyDao;

    @Autowired
    private ManyToManyFacade manyToManyFacade;

    private int greyMatterId;
    private int dataMaestersId;
    private int softwareMachineId;

    @BeforeEach
    void beforeEach() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees()
                       .add(johnSmith);
        dataMaesters.getEmployees()
                    .add(stephanieClarckson);
        dataMaesters.getEmployees()
                    .add(lindaKovalsky);
        greyMatter.getEmployees()
                  .add(johnSmith);
        greyMatter.getEmployees()
                  .add(lindaKovalsky);

        johnSmith.getCompanies()
                 .add(softwareMachine);
        johnSmith.getCompanies()
                 .add(greyMatter);
        stephanieClarckson.getCompanies()
                          .add(dataMaesters);
        lindaKovalsky.getCompanies()
                     .add(dataMaesters);
        lindaKovalsky.getCompanies()
                     .add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        greyMatterId = greyMatter.getId();
    }

    @AfterEach
    void afterEach() {
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
    }

    @Test
    void getEmployeesFromField() {
        assertAll(
                () -> assertEquals(1, manyToManyFacade.getEmployeesFromField(ManyToManyFacade.EmployeeEnum.FIRSTNAME, "Jo").size()),
                () -> assertEquals(1, manyToManyFacade.getEmployeesFromField(ManyToManyFacade.EmployeeEnum.LASTNAME, "arc").size())
        );
    }

    @Test
    void getCompaniesFromField() {
        assertAll(
                () -> assertEquals(1, manyToManyFacade.getCompaniesFromField(ManyToManyFacade.CompanyEnum.NAME, "ata").size()),
                () -> assertEquals(1, manyToManyFacade.getCompaniesFromField(ManyToManyFacade.CompanyEnum.ID, String.valueOf(greyMatterId)).size())
        );
    }
}
