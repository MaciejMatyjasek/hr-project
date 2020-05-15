package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import query.QueryConsts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeesDao {
  static final Logger log = LoggerFactory.getLogger(EmployeesDao.class);

  private String url;
  private Properties properties;

  public EmployeesDao(String url, Properties properties) {
    this.url = url;
    this.properties = properties;
  }

  public List<String> getEmployeesLastNamesByDepartmentName(String departmentName) {
    List<String> lastNames = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(url, properties)) {
      long departmentId = getDepartmentId(departmentName, con);

      PreparedStatement employeePs =
          con.prepareStatement(QueryConsts.SELECT_EMPLOYEES_LAST_NAME_BY_DEP_NAME);
      employeePs.setLong(1, departmentId);
      employeePs.setLong(2, departmentId);
      ResultSet employeesRs = employeePs.executeQuery();

      while (employeesRs.next()) {
        lastNames.add(employeesRs.getString("last_name"));
      }
    } catch (SQLException ex) {
      log.error(ex.getMessage());
    }
    return lastNames;
  }

  private long getDepartmentId(String departmentName, Connection con) throws SQLException {
    PreparedStatement departmentPs =
        con.prepareStatement("SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = ?");
    departmentPs.setString(1, departmentName);
    ResultSet departmentRs = departmentPs.executeQuery();
    long departmentId;
    if (departmentRs.next()) {
      departmentId = departmentRs.getLong("department_id");
    } else {
      log.error("Could not find department id with name: " + departmentName);
      throw new RuntimeException();
    }
    return departmentId;
  }
}
