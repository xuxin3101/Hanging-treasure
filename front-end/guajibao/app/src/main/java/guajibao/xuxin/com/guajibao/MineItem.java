package guajibao.xuxin.com.guajibao;

public class MineItem {
    private  String name;
    private  int imgid;
    public MineItem(String name, int imgid ){
        this.name=name;
        this.imgid=imgid;
    }
    public String getName(){
        return  name;
    }
    public int getImgid(){
        return imgid;
    }
}
