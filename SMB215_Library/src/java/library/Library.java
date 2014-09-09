package library;

public class Library {
    
    private int id;
    private String name;
    // image  
    private String website;
    private int mainBranch;
    private int rentalDays;
    private int reservationDays;
    private int maxReserve;
    private int rentalAlert;
    private int reservationAlert;
    private String mainCurrency;
    private String secondaryCurrency;
    private float secondaryCurrencyRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getMainBranch() {
        return mainBranch;
    }

    public void setMainBranch(int mainBranch) {
        this.mainBranch = mainBranch;
    }
    
        public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public int getReservationDays() {
        return reservationDays;
    }

    public void setReservationDays(int reservationDays) {
        this.reservationDays = reservationDays;
    }

    public int getMaxReserve() {
        return maxReserve;
    }

    public void setMaxReserve(int maxReserve) {
        this.maxReserve = maxReserve;
    }

    public int getRentalAlert() {
        return rentalAlert;
    }

    public void setRentalAlert(int rentalAlert) {
        this.rentalAlert = rentalAlert;
    }

    public int getReservationAlert() {
        return reservationAlert;
    }

    public void setReservationAlert(int reservationAlert) {
        this.reservationAlert = reservationAlert;
    }

    public String getMainCurrency() {
        return mainCurrency;
    }

    public void setMainCurrency(String mainCurrency) {
        this.mainCurrency = mainCurrency;
    }

    public String getSecondaryCurrency() {
        return secondaryCurrency;
    }

    public void setSecondaryCurrency(String secondaryCurrency) {
        this.secondaryCurrency = secondaryCurrency;
    }

    public float getSecondaryCurrencyRate() {
        return secondaryCurrencyRate;
    }

    public void setSecondaryCurrencyRate(float secondaryCurrencyRate) {
        this.secondaryCurrencyRate = secondaryCurrencyRate;
    }

    
}
