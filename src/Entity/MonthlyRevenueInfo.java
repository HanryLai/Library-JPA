package Entity;
public class MonthlyRevenueInfo {

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