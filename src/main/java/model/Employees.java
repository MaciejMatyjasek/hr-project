package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employees {
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

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(Integer phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public void setCommissionPct(String commissionPct) {
    this.commissionPct = commissionPct;
  }

  public void setManagerId(Long managerId) {
    this.managerId = managerId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }
}
