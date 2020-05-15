package builder;

import model.Employees;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class EmployeesBuilder {
  private Long employeeId;
  private String firstName;
  private String lastName;
  private String email;
  private Integer phoneNumber;
  private LocalDate hireDate;
  private Long jobId;
  private BigDecimal salary;
  private String commissionPct;
  private Long managerId;
  private Long departmentId;

  private EmployeesBuilder() {}

  public static EmployeesBuilder builder() {
    return new EmployeesBuilder();
  }

  public EmployeesBuilder employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public EmployeesBuilder firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public EmployeesBuilder lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public EmployeesBuilder email(String email) {
    this.email = email;
    return this;
  }

  public EmployeesBuilder phoneNumber(Integer phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public EmployeesBuilder hireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
    return this;
  }

  public EmployeesBuilder jobId(Long jobId) {
    this.jobId = jobId;
    return this;
  }

  public EmployeesBuilder salary(BigDecimal salary) {
    this.salary = salary;
    return this;
  }

  public EmployeesBuilder commissionPct(String commissionPct) {
    this.commissionPct = commissionPct;
    return this;
  }

  public EmployeesBuilder managerId(Long managerId) {
    this.managerId = managerId;
    return this;
  }

  public EmployeesBuilder departmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public Employees build() {
    Employees employees = new Employees();
    employees.setEmployeeId(employeeId);
    employees.setFirstName(firstName);
    employees.setLastName(lastName);
    employees.setEmail(email);
    employees.setPhoneNumber(phoneNumber);
    employees.setHireDate(hireDate);
    employees.setJobId(jobId);
    employees.setSalary(salary);
    employees.setCommissionPct(commissionPct);
    employees.setManagerId(managerId);
    employees.setDepartmentId(departmentId);
    return employees;
  }
}
