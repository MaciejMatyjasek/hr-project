package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static query.QueryConst.SELECT_DEPARTMENT_NAMES_BY_LAST_NAME;
import static query.QueryConst.SELECT_FOR_CONDITIONAL_EMPLOYEE_PAYMENT;

public class DepartmentDao {

  static final Logger log = LoggerFactory.getLogger(DepartmentDao.class);

  private String url;
  private Properties properties;

  public DepartmentDao(String url, Properties properties) {
    this.url = url;
    this.properties = properties;
  }

  public List<String> getAllDepartmentsByEmployeeLastName(String employeeLastName) {
    List<String> departmentNames = new ArrayList<>();

    try (Connection con = DriverManager.getConnection(url, properties)) {

      final boolean salaryCondition = getSalaryCondition(employeeLastName, con);
      if (salaryCondition) {
        PreparedStatement departmentNamesPs =
            con.prepareStatement(SELECT_DEPARTMENT_NAMES_BY_LAST_NAME);
        departmentNamesPs.setString(1, employeeLastName);
        departmentNamesPs.setString(2, employeeLastName);
        ResultSet departmentNamesRs = departmentNamesPs.executeQuery();
        while (departmentNamesRs.next()) {
          departmentNames.add(departmentNamesRs.getString("department_name"));
        }
      } else {
        log.error(
            "Chosen employee "
                + employeeLastName
                + ", have greater salary than 'max - (max * 25%)'.");
      }

    } catch (SQLException ex) {
      log.error(ex.getMessage());
    }
    return departmentNames;
  }

  private boolean getSalaryCondition(String employeeLastName, Connection con) throws SQLException {
    PreparedStatement salaryConditionPs =
        con.prepareStatement(SELECT_FOR_CONDITIONAL_EMPLOYEE_PAYMENT);
    salaryConditionPs.setString(1, employeeLastName);
    ResultSet salaryConditionRs = salaryConditionPs.executeQuery();
    return salaryConditionRs.next();
  }
}
