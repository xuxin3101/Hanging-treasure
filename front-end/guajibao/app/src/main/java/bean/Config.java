package bean;

public class Config {
    /*
    {"data":{"minwithdraw":"2.00","qq":"123","endtime":"123","cricletime":"2","incomerate":"0.2300",
    "id":"1107987768862048256","starttime":"123","minamount":"22.00","announce":"123123"},"success":200}
     */
    private String minwithdraw;
    private String qq;
    private String endtime;
    private String cricletime;
    private String incomerate;
    private String id;
    private String starttime;
    private String minamount;
    private String announce;

    public void setId(String id) {
        this.id = id;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setCricletime(String cricletime) {
        this.cricletime = cricletime;
    }

    public String getCricletime() {
        return cricletime;
    }

    public String getId() {
        return id;
    }

    public void setMinwithdraw(String minwithdraw) {
        this.minwithdraw = minwithdraw;
    }

    public String getMinwithdraw() {
        return minwithdraw;
    }

    public String getAnnounce() {
        return announce;
    }

    public String getIncomerate() {
        return incomerate;
    }

    public String getMinamount() {
        return minamount;
    }

    public String getQq() {
        return qq;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    public void setIncomerate(String incomerate) {
        this.incomerate = incomerate;
    }

    public void setMinamount(String minamount) {
        this.minamount = minamount;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
