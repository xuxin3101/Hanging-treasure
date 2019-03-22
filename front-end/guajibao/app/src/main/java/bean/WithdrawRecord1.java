package bean;

import java.util.List;

public class WithdrawRecord1 {
    private String success;
    private List<WithdrawRecord> data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setData(List<WithdrawRecord> data) {
        this.data = data;
    }

    public List<WithdrawRecord> getData() {
        return data;
    }
}
