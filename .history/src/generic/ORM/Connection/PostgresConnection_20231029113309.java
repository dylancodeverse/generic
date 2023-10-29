package generic.ORM.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection extends GeneralConnection 
{

    @Override
    public Connection connect() throws SQLException, ClassNotFoundException 
    {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://"+address+"/", user, password) ;
    }

}
