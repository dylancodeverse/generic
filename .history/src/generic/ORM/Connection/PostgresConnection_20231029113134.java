package generic.ORM.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection extends GeneralConnection 
{

    @Override
    public Connection connect() throws SQLException 
    {
        return DriverManager.getConnection("jdbc:postgresql://"+address+"/", user, password) ;
    }

}
