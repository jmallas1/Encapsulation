package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;
    private String fmtOrientationDate;

    public Employee(String firstName, String lastName, String ssn) {
        if (isValidName(firstName)) { setFirstName(firstName);}
        if (isValidName(lastName)) { setLastName(lastName); }
        if (isValidSSN(ssn)) { setSsn(ssn); }

        firstDay();
    }

    private void firstDay() {
        setOrientationDate(new Date());
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(this.getCubeId());
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalryInfo() {
        setMetWithHr(true);
        System.out.println(firstName + " " + lastName + " met with Hr on "
                + this.fmtOrientationDate);
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.:
    private void meetDepartmentStaff() {
        setMetDeptStaff(true);
        System.out.println(firstName + " " + lastName + " met with Dept. Staff on "
                + this.fmtOrientationDate);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    private void reviewDeptPolicies() {
        setReviewedDeptPolicies(true);
        System.out.println(firstName + " " + lastName + " reviewed Dept policies on "
                + this.fmtOrientationDate);
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    private void moveIntoCubicle(String cubeId) {
        if (isValidCubeID(genOpenCubeId()))
        {
            setCubeId(genOpenCubeId());
        }
        setMovedIn(true);
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + this.fmtOrientationDate);
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    private void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    private void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    private void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    private void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    private void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    private void setOrientationDate(Date orientationDate) {
        this.orientationDate = orientationDate;
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        this.fmtOrientationDate = sdf.format(orientationDate);
    }

    // validation methods
    private boolean isValidName(String name)
    {
        return true;
    }

    private boolean isValidSSN(String ssn)
    {
        return true;
    }

    private boolean isValidCubeID(String cubeId)
    {
        return true;
    }

    private String genOpenCubeId()
    {
        return "1234";
    }
}
