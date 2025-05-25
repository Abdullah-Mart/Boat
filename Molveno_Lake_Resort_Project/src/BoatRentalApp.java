public class BoatRentalApp {
    public static void main(String[] args) {
        HotelSystem hotelSystem = new HotelSystem();

        User user1 = new User("john_doe", "guest");

        // User views available boats
        hotelSystem.viewAvailableBoats();

        // User makes a reservation
        hotelSystem.makeReservation(user1, "Boat 1", 60, "Credit Card");

        // Display user's reservations
        hotelSystem.displayReservations(user1);

        // Cancel a reservation
        hotelSystem.cancelReservation(user1, "Boat 1");

        // View available boats again
        hotelSystem.viewAvailableBoats();
    }
}
