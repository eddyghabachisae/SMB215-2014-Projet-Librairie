package Item;

public class Item {

    private long id;
    private String name;
    private long itemCategory_id;
    private String barcode;
    private String imgBracodePath;
    private String imgPath;
    private String description;
    private double avgUnitCost;
    private double saleRentPrice;
    private int minLimit;
    private int maxLimit;
    private int quantity;
    public boolean isAvailable;
    public boolean isActive;
    public String deactivationReason;

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", itemCategory_id=" + itemCategory_id + ", barcode=" + barcode + ", imgBracodePath=" + imgBracodePath + ", imgPath=" + imgPath + ", description=" + description + ", avgUnitCost=" + avgUnitCost + ", saleRentPrice=" + saleRentPrice + ", minLimit=" + minLimit + ", maxLimit=" + maxLimit + ", quantity=" + quantity + ", isAvailable=" + isAvailable + ", isActive=" + isActive + ", deactivationReason=" + deactivationReason + '}';
    }

    public Item(long id, String name, long itemCategory_id, String barcode, String imgBracodePath, String imgPath, String description, double avgUnitCost, double saleRentPrice, int minLimit, int maxLimit, int quantity, boolean isAvailable, boolean isActive, String deactivationReason) {
        this.id = id;
        this.name = name;
        this.itemCategory_id = itemCategory_id;
        this.barcode = barcode;
        this.imgBracodePath = imgBracodePath;
        this.imgPath = imgPath;
        this.description = description;
        this.avgUnitCost = avgUnitCost;
        this.saleRentPrice = saleRentPrice;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
        this.isActive = isActive;
        this.deactivationReason = deactivationReason;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getItemCategory_id() {
        return itemCategory_id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getImgBracodePath() {
        return imgBracodePath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getDescription() {
        return description;
    }

    public double getAvgUnitCost() {
        return avgUnitCost;
    }

    public double getSaleRentPrice() {
        return saleRentPrice;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getDeactivationReason() {
        return deactivationReason;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemCategory_id(long itemCategory_id) {
        this.itemCategory_id = itemCategory_id;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setImgBracodePath(String imgBracodePath) {
        this.imgBracodePath = imgBracodePath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvgUnitCost(double avgUnitCost) {
        this.avgUnitCost = avgUnitCost;
    }

    public void setSaleRentPrice(double saleRentPrice) {
        this.saleRentPrice = saleRentPrice;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setDeactivationReason(String deactivationReason) {
        this.deactivationReason = deactivationReason;
    }

}
