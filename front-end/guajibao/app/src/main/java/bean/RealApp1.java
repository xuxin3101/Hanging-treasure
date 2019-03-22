package bean;

import java.util.List;

public class RealApp1 {
    private String success;
    private List<RealApp> data;

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    public void setData(List<RealApp> data) {
        this.data = data;
    }

    public List<RealApp> getData() {
        return data;
    }
}
