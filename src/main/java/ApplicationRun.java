import dao.EmployeesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.EmployeesService;

import java.util.List;

import static configuration.DataSourceDefinition.getProperties;
import static configuration.DataSourceDefinition.getUrl;

public class ApplicationRun {

  static final Logger log = LoggerFactory.getLogger(ApplicationRun.class);

  public static void main(String[] args) {
    String departmentName = "DRK";
    EmployeesDao employeesDao = new EmployeesDao(getUrl(), getProperties());
    EmployeesService employeesService = new EmployeesService(employeesDao);

    fetchEmployeesAndDisplay(departmentName, employeesService);
  }

  private static void fetchEmployeesAndDisplay(String departmentName, EmployeesService employeesService) {
    final List<String> employeesLastNamesByDepartmentName =
        employeesService.fetchEmployeesLastNamesByDepartmentName(departmentName);

    employeesLastNamesByDepartmentName.forEach(
        last_name -> log.info("Last_Name: " + last_name + "\n"));
  }
}
