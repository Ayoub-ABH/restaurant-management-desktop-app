package Default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ali");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        return con;
    }
}
