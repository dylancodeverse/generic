package generic.ORM.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection extends GeneralConnection 
{

    @Override
    public Connection connect() throws SQLException 
    {
        Connection connection = null;

        connection = DriverManager.getConnection(url, user, password) ;
    }

}
