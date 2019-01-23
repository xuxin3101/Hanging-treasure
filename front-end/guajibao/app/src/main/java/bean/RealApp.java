package bean;
//2.0版本app
public class RealApp {
    private String id;
    private String title;
    private String appname;
    private String price;
    private String img;
    private String readtime;
    private String time;
    private String content;
    private String logo;

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

    public String getReadtime() {
        return readtime;
    }


    public void setReadtime(String readtime) {
        this.readtime = readtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppname() {
        return appname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
