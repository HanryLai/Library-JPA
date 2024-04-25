package entity;

public class ProductInfo {

    private String productId;
    private int totalQuantity;

    public ProductInfo(String productId, int totalQuantity) {
        this.productId = productId;
        this.totalQuantity = totalQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
}
