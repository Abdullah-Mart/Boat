// Reservation.java
import java.util.Date;

public class Reservation {
    private Date startDate;
    private int durationMinutes; // Kiralama süresi dakikalar cinsinden
    private String boatType;
    private HotelSystem hotelSystem;

    // Constructor
    public Reservation(Date startDate, int durationMinutes, String boatType) {
        this.startDate = startDate;
        this.durationMinutes = durationMinutes;
        this.boatType = boatType;
        this.hotelSystem = new HotelSystem();
    }

    // Getter ve Setter metotları
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public HotelSystem getHotelSystem() {
        return hotelSystem;
    }

    public void setHotelSystem(HotelSystem hotelSystem) {
        this.hotelSystem = hotelSystem;
    }

    // HotelSystem iç sınıfı
    public class HotelSystem {
        private String paymentMethod;

        public HotelSystem() {
        }

        // Ödeme yöntemi belirleme metodu
        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        // Bakım için bot ayarlama metodu
        public void maintenance(String boatName) {
            System.out.println("Boat " + boatName + " is scheduled for maintenance.");
        }

        // Elektrikli botları şarj etme metodu
        public void chargeElectricalBoat(String boatId) {
            System.out.println("Electrical Boat " + boatId + " is now charging.");
        }
    }
}
