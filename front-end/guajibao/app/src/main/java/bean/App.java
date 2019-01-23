package bean;
/*1.0版本app*/
public class App {
    private String id;
    private String title;
    private String company;
    private String price;
    private String link;
    private String readtime;
    private String time;

    public String getId() {
        return id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLink() {
        return link;
    }

    public String getReadtime() {
        return readtime;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setReadtime(String readtime) {
        this.readtime = readtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
