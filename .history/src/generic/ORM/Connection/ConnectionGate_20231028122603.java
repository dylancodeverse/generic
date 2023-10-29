package generic.ORM.Connection;

public class ConnectionGate {
    
    protected String url;
    protected String user;
    protected String password;
    protected boolean useAuto

    public ConnectionGate() {
    }

    public ConnectionGate(String url, String user, String password) {

        setUrl(url);
        setUser(user);
        setPassword(password);

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

}
