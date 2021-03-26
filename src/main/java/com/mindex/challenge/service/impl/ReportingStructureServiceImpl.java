package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private ReportingStructureRepository reportingStructureRepository;

    @Override
    public ReportingStructure report(Employee employee) {
        List<Employee> reportList = new ArrayList<>();

        for (Employee emp : employee.getDirectReports()) {
            if (employee.getDirectReports().size() > 0) {
                reportList.add(emp);
            } else {
                continue;
            }
        }
        return (ReportingStructure) reportList;
    }
}
