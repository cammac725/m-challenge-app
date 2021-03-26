package com.mindex.challenge.data;

public class ReportingStructure {
    private String employee;
    private int numberOfReports;

    public ReportingStructure(String employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getNumberOfReports(Employee employee) {
        return employee.getDirectReports().size();
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
