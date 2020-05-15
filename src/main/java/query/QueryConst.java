package query;

public class QueryConst {

  public static final String SELECT_EMPLOYEES_LAST_NAME_BY_DEP_NAME =
      "SELECT LAST_NAME "
          + "FROM EMPLOYEES "
          + "WHERE DEPARTMENT_ID = ? "
          + "UNION "
          + "SELECT LAST_NAME "
          + "FROM EMPLOYEES E "
          + "         JOIN JOB_HISTORY JH "
          + "              ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID "
          + "WHERE JH.DEPARTMENT_ID = ?"
          + "ORDER BY LAST_NAME";

  public static final String SELECT_DEPARTMENT_ID_BY_DEPARTMENT_NAME =
      "SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = ?";

  public static final String SELECT_FOR_CONDITIONAL_EMPLOYEE_PAYMENT =
      "SELECT SALARY FROM EMPLOYEES E "
          + "LEFT JOIN JOBS  J  ON E.JOB_ID = J.JOB_ID "
          + "where E.LAST_NAME = ? "
          + "AND (J.MAX_SALARY - (0.25 * J.MAX_SALARY) > E.SALARY)";

  public static final String SELECT_DEPARTMENT_NAMES_BY_LAST_NAME =
      "SELECT DEPARTMENT_NAME from DEPARTMENTS "
          + "    WHERE DEPARTMENT_ID IN (SELECT E.DEPARTMENT_ID from EMPLOYEES E "
          + "                            where E.LAST_NAME = ? "
          + "                            UNION "
          + "                            SELECT JH.DEPARTMENT_ID FROM JOB_HISTORY JH "
          + "                            WHERE JH.EMPLOYEE_ID = (SELECT EMPLOYEE_ID from EMPLOYEES where LAST_NAME = ?)) "
          + "ORDER BY DEPARTMENT_NAME";
}
