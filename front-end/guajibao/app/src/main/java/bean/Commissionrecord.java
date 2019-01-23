package bean;

public class Commissionrecord {
    private String id;
    private String appname;
    private String time;
    private String price;
    private String username;

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
