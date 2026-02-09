package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryAdapterTestSuite {

    @Test
    void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        System.out.println("Total salary: " + totalSalary);
        assertEquals(27750, totalSalary, 0);
    }
}
