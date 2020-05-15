import dao.DepartmentDao;
import dao.EmployeesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DepartmentService;
import service.EmployeesService;

import java.util.List;

import static configuration.DataSourceDefinition.getProperties;
import static configuration.DataSourceDefinition.getUrl;

public class ApplicationRun {

  static final Logger log = LoggerFactory.getLogger(ApplicationRun.class);

  public static void main(String[] args) {
    String departmentName = "DRK";
    String employeeLastName = "Kowalski";

    EmployeesDao employeesDao = new EmployeesDao(getUrl(), getProperties());
    EmployeesService employeesService = new EmployeesService(employeesDao);

    DepartmentDao departmentDao = new DepartmentDao(getUrl(), getProperties());
    DepartmentService departmentService = new DepartmentService(departmentDao);

    fetchEmployeesAndDisplay(departmentName, employeesService);

    fetchDepartmentsAndDisplay(employeeLastName, departmentService);
  }

  private static void fetchEmployeesAndDisplay(
      String departmentName, EmployeesService employeesService) {
    final List<String> employeesLastNamesByDepartmentName =
        employeesService.fetchEmployeesLastNamesByDepartmentName(departmentName);
    log.info("##TASK 1 RESULT##");
    employeesLastNamesByDepartmentName.forEach(last_name -> log.info("Last_Name: " + last_name));
  }

  private static void fetchDepartmentsAndDisplay(
      String employeeLastName, DepartmentService departmentService) {
    final List<String> departmentsByLastName =
        departmentService.fetchAllEmployeeDepartmentByLastName(employeeLastName);
    log.info("##TASK 2 RESULT##");
    departmentsByLastName.forEach(department_name -> log.info("Department: " + department_name));
  }
}
