package com.employee.service;

import com.employee.entity.EmployeeEntity;
import com.employee.entity.PresenceEntity;
import com.employee.entity.SallesPersonEntity;

import java.util.Date;

public class ManagerService {
    public void logEmployeePresence(EmployeeEntity employee) {
        Date now = new Date();
        employee.setPresence(new PresenceEntity(now, true));
    }

    public boolean isReachedTheTargetInTheLast3Months(SallesPersonEntity employee) {
        double salesAvage = (double) employee.getPresence().length / employee.getSales().length;
    }
}
