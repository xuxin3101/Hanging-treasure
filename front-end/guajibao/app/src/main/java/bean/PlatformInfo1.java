package bean;

import java.util.List;

public class PlatformInfo1 {
    private String success;
    private List<PlatformInfo> data;

    public void setData(List<PlatformInfo> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<PlatformInfo> getData() {
        return data;
    }
}
