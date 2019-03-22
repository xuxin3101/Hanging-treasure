package bean;

import java.util.List;

public class Commissionrecord2 {
    private String total;
    private List<Commissionrecord> rows;

    public List<Commissionrecord> getRows() {
        return rows;
    }

    public String getTotal() {
        return total;
    }

    public void setRows(List<Commissionrecord> rows) {
        this.rows = rows;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
