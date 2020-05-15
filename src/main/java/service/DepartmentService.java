package service;

import dao.DepartmentDao;

import java.util.List;

public class DepartmentService {

  private DepartmentDao departmentDao;

  public DepartmentService(DepartmentDao departmentDao) {
    this.departmentDao = departmentDao;
  }

  public List<String> fetchAllEmployeeDepartmentByLastName(String employeeLastName) {
    return departmentDao.getAllDepartmentsByEmployeeLastName(employeeLastName);
  }
}
