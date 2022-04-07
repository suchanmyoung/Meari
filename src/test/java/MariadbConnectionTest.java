import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariadbConnectionTest {

    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://meari.czrjpw6gk1iv.us-east-1.rds.amazonaws.com:3306/meari";
    private static final String USER = "admin";
    private static final String PASSWORD = "de741852";

    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
