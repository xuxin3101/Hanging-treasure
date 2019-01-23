package bean;

public class IndexInfo {
    private String amount;
    private String withdrawed;
    private String tuijian;
    private String balance;
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getBalance() {
        return balance;
    }

    public String getTuijian() {
        return tuijian;
    }

    public String getWithdrawed() {
        return withdrawed;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setTuijian(String tuijian) {
        this.tuijian = tuijian;
    }

    public void setWithdrawed(String withdrawed) {
        this.withdrawed = withdrawed;
    }
}
