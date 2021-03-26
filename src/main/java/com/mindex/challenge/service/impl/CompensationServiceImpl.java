package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;

public class CompensationServiceImpl implements CompensationService {

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation compensation) {
        Compensation newCompensation = new Compensation();

        newCompensation.setEmployee(compensation.getEmployee());
        newCompensation.setSalary(compensation.getSalary());
        newCompensation.setEmployee(compensation.getEffectiveDate());

        return compensationRepository.save(compensation);
    }

    @Override
    public Compensation read(String id) {
        Compensation compensation = compensationRepository.findByEmployee(id);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}
