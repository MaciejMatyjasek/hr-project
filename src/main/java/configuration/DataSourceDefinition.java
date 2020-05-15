package configuration;

import java.util.Properties;

public class DataSourceDefinition {

  public static String getUrl() {
    return "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
  }

  public static Properties getProperties() {
    Properties properties = new Properties();
    properties.setProperty("user", "HR");
    properties.setProperty("password", "Hrproject20");
    return properties;
  }
}
