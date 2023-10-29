package generic.ORM.Connection;

import java.sql.Connection;

public abstract class GeneralConnection {

    protected String url;
    protected String user;
    protected String password;
    protected boolean useAutoCommit;

    public GeneralConnection() {
    }

    public GeneralConnection(String url, String user, String password) {

        setUrl(url);
        setUser(user);
        setPassword(password);

    }

    public abstract Connection connect();

    public Connection connect(boolean useAutoCommit) {

        setUseAutoCommit(useAutoCommit);
        return connect();

    }

    // GETTERS AND SETTERS
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
