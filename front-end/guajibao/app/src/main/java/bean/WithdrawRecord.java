package bean;

public class WithdrawRecord {
    private String id;
    private String username;
    private String amount;
    private String alipay;
    private String name;
    private String state;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getTime() {
        return time;
    }

    public String getAlipay() {
        return alipay;
    }

    public String getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
