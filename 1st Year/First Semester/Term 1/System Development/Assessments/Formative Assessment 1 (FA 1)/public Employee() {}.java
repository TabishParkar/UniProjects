public Employee() 

public Employee(String n, String sn, String num) {
    empName = n;
    empSurname = sn;
    empNumber = num;
}

public void setEmpName(String nm) {
    empName = nm;
}

public void setEmpSurname(String snm) {
    empSurname = snm;
}

public void setEmpNumber(String num) {
    empNumber = num;
}

public void setEmpSalary(double sal) 
    empSalary = sal;


public String getEmpName() {
    return empName;
}

public String getEmpSurname() {
    return empSurname;
}

public String getEmpNumber() {
    return empNumber;
}

public double getEmpSalary() {
    return empSalary;
}

public void increaseSalary(double sal) {
    empSalary += amt;
}

public String toString() {
    return "Employee Name: " + empName + "\nEmployee Surname: " + empSurname + "\nEmployee Number: " + empNumber + "\nEmployee Salary: " + empSalary

