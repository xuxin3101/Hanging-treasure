package Users;

import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import bean.Cricletime;
import bean.Noincometime;
import bean.UserInfo;
import guajibao.xuxin.com.guajibao.Appsitem;

public class SystemData {
    private static CheckBox checkBox1;
    private static  CheckBox checkBox2;
    public static String BASEURL="http://rr.xmys.org/shiwanbao";
    private  UserInfo userInfo;
    private String announcement;
    private Cricletime cricletime;
    private Noincometime noincometime;
    private  List<Appsitem> appsitemList=new ArrayList<Appsitem>();
    private static SystemData intstent=new SystemData();
    public static  boolean WORK_STATUE=false;
    private List<Appsitem> realapplistList=null;
    private SystemData(){
    }

    public Noincometime getNoincometime() {
        return noincometime;
    }

    public void setNoincometime(Noincometime noincometime) {
        this.noincometime = noincometime;
    }

    public static SystemData getIntstent(){
        return  intstent;
    }
    public static void setCheckBox1(CheckBox checkbox){
        SystemData.checkBox1=checkbox;
    }
    public static void setCheckBox2(CheckBox checkBox){
        SystemData.checkBox2=checkBox;
    }
    public static CheckBox getCheckBox1() {
        return checkBox1;
    }

    public static CheckBox getCheckBox2() {
        return checkBox2;
    }
    public List<Appsitem> getAppsitemList(){
        return appsitemList;
    }
    public void setAppsitemList(List<Appsitem> appsitemList){
        this.appsitemList=appsitemList;
    }
    public void setUserInfo(UserInfo userInfo){
        this.userInfo=userInfo;
    }
    public  UserInfo getUserInfo(){
        return userInfo;
    }
    public void setAnnouncement(String announcement){
        this.announcement=announcement;
    }
    public String getAnnouncement(){
        return this.announcement;
    }

    public void setCricletime(Cricletime cricletime) {
        this.cricletime = cricletime;
    }

    public Cricletime getCricletime() {
        return cricletime;
    }

    public List<Appsitem> getRealapplistList() {
        return realapplistList;
    }
    public void setRealapplistList(List<Appsitem> realapplistList) {
        this.realapplistList = realapplistList;
    }
}
