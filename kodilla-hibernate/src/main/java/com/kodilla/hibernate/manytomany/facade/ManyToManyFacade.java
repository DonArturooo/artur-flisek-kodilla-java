package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyFacade {
    public enum EmployeeEnum {
        FIRSTNAME,
        LASTNAME,
        ID
    }

    public enum CompanyEnum {
        NAME,
        ID
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;


    @Autowired
    public ManyToManyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;

    }

    public List<Employee> getEmployeesFromField(EmployeeEnum field, String value) {
        LOGGER.info("Search employee from table " + field.name() + " with value: " + value);

        try {
            if(field.equals(EmployeeEnum.FIRSTNAME)) {
                return employeeDao.findFromFirstname(value);
            }
            else if (field.equals(EmployeeEnum.LASTNAME)) {
                return employeeDao.findFromLastname(value);
            } else {
                return employeeDao.findEmployeeFromId(Long.parseLong(value));
            }
        } catch (Exception e){
            LOGGER.error("Searching error: " + e.getMessage());
            return null;
        } finally {
            LOGGER.info("Searching finished");
        }
    }

    public List<Company> getCompaniesFromField(CompanyEnum field, String value) {
        LOGGER.info("Search company from table " + field.name() + " with value: " + value);

        try {
            if(field.equals(CompanyEnum.NAME)) {
                return companyDao.findFromCompanyName(value);
            }
            else {
                System.out.println("Wartość id to " + Long.parseLong(value));
                return companyDao.findCompanyFromId(Long.parseLong(value));
            }
        } catch (Exception e){
            LOGGER.error("Searching error: " + e.getMessage());
            return null;
        } finally {
            LOGGER.info("Searching finished");
        }
    }
}
