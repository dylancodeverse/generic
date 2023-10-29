package generic.ORM.Connection;

import java.sql.Connection;

public abstract class GeneralConnection {

    protected String adress;
    protected String user;
    protected String password;
    protected boolean useAutoCommit = false;

    public GeneralConnection() {
    }

    public GeneralConnection(String adress, String user, String password) {

        setadress(adress);
        setUser(user);
        setPassword(password);

    }

    public abstract Connection connect();

    public Connection connect(boolean useAutoCommit) {

        // set auto commit
        boolean temp = useAutoCommit;
        setUseAutoCommit(useAutoCommit);

        Connection connection = connect();

        // change autoCommit to default
        setUseAutoCommit(temp);

        return connection;
    }

    // GETTERS AND SETTERS
    public String getadress() {
        return adress;
    }

    public void setadress(String adress) {
        this.adress = adress;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUseAutoCommit() {
        return useAutoCommit;
    }

    public void setUseAutoCommit(boolean useAutoCommit) {
        this.useAutoCommit = useAutoCommit;
    }

}
