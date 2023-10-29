package generic.ORM.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection extends GeneralConnection 
{

    @Override
    public Connection connect() 
    {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password) ;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
