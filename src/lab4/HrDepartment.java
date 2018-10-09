package lab4;

import java.util.ArrayList;

public class HrDepartment
{
    private ArrayList<Employee> employees;

    public void HrDepartment()
    {
        employees = new ArrayList();
    }

    public void hireEmployee(String fName, String lName, String ssn)
    {
        Employee fng = new Employee(fName, lName, ssn);
        employees.add(fng);
        employeeOnBoarding(fng);
    }

    private void employeeOnBoarding(Employee someEmployee)
    {
        String cubie = "1234";
        someEmployee.doFirstTimeOrientation(cubie);
    }

    public void doReport(String ssn)
    {
        Employee someEmployee = null;

        for (Employee x : employees)
        {
            if(x.getSsn().equals(ssn))
            {
                someEmployee = x;
                break;
            }
        }

        someEmployee.getReportService().outputReport();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
