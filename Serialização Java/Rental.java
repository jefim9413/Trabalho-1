import java.io.Serializable;

public class Rental implements Serializable {
    private Video video;
    private String customerName;
    private int rentalDays;

    public Rental(Video video, String customerName, int rentalDays) {
        this.video = video;
        this.customerName = customerName;
        this.rentalDays = rentalDays;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    public String toString() {
        return "Rental [video=" + video + ", customerName=" + customerName + ", rentalDays=" + rentalDays + "]";
    }
}
