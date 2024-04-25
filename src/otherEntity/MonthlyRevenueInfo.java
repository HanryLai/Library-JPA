package otherEntity;

import java.io.Serializable;

public class MonthlyRevenueInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int month;
    private double totalRevenue;

    public MonthlyRevenueInfo(int month, double totalRevenue) {
        this.month = month;
        this.totalRevenue = totalRevenue;
    }

    public int getMonth() {
        return month;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}