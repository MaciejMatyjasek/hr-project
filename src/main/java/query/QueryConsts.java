package query;

public class QueryConsts {

  public static final String SELECT_EMPLOYEES_LAST_NAME_BY_DEP_NAME =
      "SELECT LAST_NAME "
          + "FROM EMPLOYEES "
          + "WHERE DEPARTMENT_ID = ? "
          + "UNION "
          + "SELECT LAST_NAME "
          + "FROM EMPLOYEES E "
          + "         JOIN JOB_HISTORY JH "
          + "              ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID "
          + "WHERE JH.DEPARTMENT_ID = ?";
}
