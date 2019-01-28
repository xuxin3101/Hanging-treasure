package bean;

public class UserInfo {
    private String username;
    private  String password;
    private  String id;
    private  String idcard;
    private  String alipayaccount;
    private  String alipayname;
    private  String bankaccount;
    private  String bankplace;
    private  String token;
    private String wechatqrcode;
    private String alipayqrcode;
    public String getAlipayaccount() {
        return alipayaccount;
    }

    public String getAlipayname() {
        return alipayname;
    }

    public String getId() {
        return id;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setAlipayaccount(String alipayaccount) {
        this.alipayaccount = alipayaccount;
    }

    public void setAlipayname(String alipayname) {
        this.alipayname = alipayname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public void setBankplace(String bankplace) {
        this.bankplace = bankplace;
    }

    public String getBankplace() {
        return bankplace;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public void setAlipayqrcode(String alipayqrcode) {
        this.alipayqrcode = alipayqrcode;
    }

    public String getAlipayqrcode() {
        return alipayqrcode;
    }

    public String getWechatqrcode() {
        return wechatqrcode;
    }

    public void setWechatqrcode(String wechatqrcode) {
        this.wechatqrcode = wechatqrcode;
    }
}
