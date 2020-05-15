package service;

import dao.EmployeesDao;

import java.util.List;

public class EmployeesService {

  private EmployeesDao employeesDao;

  public EmployeesService(EmployeesDao employeesDao) {
    this.employeesDao = employeesDao;
  }

  public List<String> fetchEmployeesLastNamesByDepartmentName(String departmentName) {
    return employeesDao.getEmployeesLastNamesByDepartmentName(departmentName);
  }
}
