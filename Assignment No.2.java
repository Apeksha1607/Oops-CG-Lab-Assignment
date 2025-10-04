import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    String guestName;
    int roomNumber;
    int daysStayed;
    static final int ROOM_RATE = 100;  // Fixed rate per day

    Booking(String guestName, int roomNumber, int daysStayed) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.daysStayed = daysStayed;
    }

    int getBill() {
        return daysStayed * ROOM_RATE;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + ", Guest: " + guestName + ", Days: " + daysStayed + ", Bill: $" + getBill();
    }
}

public class HotelManagement {
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBooking() {
        System.out.print("Enter guest name: ");
        String name = sc.nextLine();
        System.out.print("Enter room number: ");
        int room = Integer.parseInt(sc.nextLine());
        System.out.print("Enter number of days stayed: ");
        int days = Integer.parseInt(sc.nextLine());

        // Check if room is already booked
        for (Booking b : bookings) {
            if (b.roomNumber == room) {
                System.out.println("Room " + room + " is already booked.");
                return;
            }
        }

        bookings.add(new Booking(name, room, days));
        System.out.println("Booking added successfully.\n");
    }

    public static void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.\n");
            return;
        }
        System.out.println("Current Bookings:");
        for (Booking b : bookings) {
            System.out.println(b);
        }
        System.out.println();
    }

    public static void cancelBooking() {
        System.out.print("Enter room number to cancel booking: ");
        int room = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).roomNumber == room) {
                bookings.remove(i);
                System.out.println("Booking for room " + room + " cancelled.\n");
                return;
            }
        }
        System.out.println("No booking found for room " + room + ".\n");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Hotel Management System");
            System.out.println("1. Add Booking");
            System.out.println("2. Display Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addBooking();
                    break;
                case 2:
                    displayBookings();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        } while (choice != 0);

        sc.close();
    }
}
