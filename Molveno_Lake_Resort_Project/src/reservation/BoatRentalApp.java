package reservation;

import java.util.*;

class Boat {
    String boatName;
    boolean isAvailable;

    public Boat(String boatName) {
        this.boatName = boatName;
        this.isAvailable = true;
    }

    public String getBoatName() {
        return boatName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        this.isAvailable = false;
    }

    public void cancelReservation() {
        this.isAvailable = true;
    }
}

class Reservation {
    String user;
    Boat boat;
    int duration;
    String paymentMethod;

    public Reservation(String user, Boat boat, int duration, String paymentMethod) {
        this.user = user;
        this.boat = boat;
        this.duration = duration;
        this.paymentMethod = paymentMethod;
        boat.reserve();
    }

    public void cancel() {
        boat.cancelReservation();
    }

    public void updateReservation(int newDuration) {
        this.duration = newDuration;
    }

    public void displayReservation() {
        System.out.println("User: " + user + " | Boat: " + boat.getBoatName() + " | Duration: " + duration + " mins | Payment: " + paymentMethod);
    }
}

class User {
    String username;
    String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}

class HotelSystem {
    List<Boat> boats = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    public HotelSystem() {
        boats.add(new Boat("Boat 1"));
        boats.add(new Boat("Boat 2"));
        boats.add(new Boat("Boat 3"));
    }

    public void viewAvailableBoats() {
        for (Boat boat : boats) {
            if (boat.isAvailable()) {
                System.out.println(boat.getBoatName() + " is available.");
            }
        }
    }

    public void makeReservation(User user, String boatName, int duration, String paymentMethod) {
        Boat selectedBoat = null;
        for (Boat boat : boats) {
            if (boat.getBoatName().equals(boatName) && boat.isAvailable()) {
                selectedBoat = boat;
                break;
            }
        }
        if (selectedBoat != null && duration % 30 == 0) {
            Reservation reservation = new Reservation(user.getUsername(), selectedBoat, duration, paymentMethod);
            reservations.add(reservation);
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Invalid reservation. Either boat is not available or duration is not valid.");
        }
    }

    public void cancelReservation(User user, String boatName) {
        for (Reservation reservation : reservations) {
            if (reservation.user.equals(user.getUsername()) && reservation.boat.getBoatName().equals(boatName)) {
                reservation.cancel();
                reservations.remove(reservation);
                System.out.println("Reservation cancelled.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public void displayReservations(User user) {
        for (Reservation reservation : reservations) {
            if (reservation.user.equals(user.getUsername())) {
                reservation.displayReservation();
            }
        }
    }
}

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
