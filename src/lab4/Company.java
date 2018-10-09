package lab4;

public class Company
{
    private HrDepartment hr;

    public void Company()
    {
        hr = new HrDepartment();
    }

    public void hireEmployee(String fName, String lName, String ssn)
    {
        hr.hireEmployee(fName, lName, ssn);
        hr.doReport(ssn);
    }

    public HrDepartment getHr() {
        return hr;
    }

    public void setHr(HrDepartment hr) {
        this.hr = hr;
    }
}
