import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class RailwayReservationSystem{
    static ArrayList<Train> trains = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static int ticketCounter = 1001;

    public static void main(String[] args) {
        initializeTrains();
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nRailway Reservation System");
            System.out.println("1. Train Information");
            System.out.println("2. Seat Availability");
            System.out.println("3. Booking");
            System.out.println("4. Canceling");
            System.out.println("5. Ticket Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayTrainInformation();
                    break;
                case 2:
                    checkSeatAvailability(scanner);
                    break;
                case 3:
                    bookTicket(scanner);
                    break;
                case 4:
                    cancelTicket(scanner);
                    break;
                case 5:
                    displayTicketDetails(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using the Railway Reservation System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void initializeTrains() {
        trains.add(new Train("Mumbai - Delhi", "13:05", 50, 1010));
        trains.add(new Train("Delhi - Jaipur", "7:00", 50, 2013));
        trains.add(new Train("Chennai - Delhi", "10:00", 50, 3045));
        trains.add(new Train(" "," ",0,0));
        
    }

    static void displayTrainInformation() {
        System.out.println("Train Information:");
        System.out.println("Train Number"+"\t"+"Train Name"+"\t\t"+"Time"+"\t"+"Passenger Strength");
        for (Train train : trains) {
            System.out.println(train.trainNumber + "\t\t" + train.name + "\t\t" + train.time + "\t" + train.passengerStrength);
        }
    }

    static void checkSeatAvailability(Scanner scanner) {
        System.out.print("Enter the train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (Train train : trains) {
            if (train.trainNumber == trainNumber) {
                int availableSeats = train.passengerStrength - countBookedSeats(trainNumber);
                System.out.println("Available seats on Train " + trainNumber + ": " + availableSeats);
                return;
            }
        }

        System.out.println("Train not found.");
    }

    static int countBookedSeats(int trainNumber) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (ticket.trainNumber == trainNumber) {
                count++;
            }
        }
        return count;
    }

    static void bookTicket(Scanner scanner) {
        System.out.print("Enter your name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Enter the train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int availableSeats = trains.get(trainNumber - 1010).passengerStrength - countBookedSeats(trainNumber);

        if (availableSeats > 0) {
            String seatNumber = "S" + (1010 + trainNumber) + "-" + (ticketCounter++);
            Ticket ticket = new Ticket(ticketCounter, passengerName, trainNumber, seatNumber);
            tickets.add(ticket);
            System.out.println("Ticket booked successfully! Your seat number is " + seatNumber);
        } else {
            System.out.println("Sorry, no seats available on this train.");
        }
    }

    static void cancelTicket(Scanner scanner) {
        System.out.print("Enter your ticket number: ");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (Ticket ticket : tickets) {
            if (ticket.ticketNumber == ticketNumber) {
                tickets.remove(ticket);
                System.out.println("Ticket canceled successfully.");
                return;
            }
        }

        System.out.println("Ticket not found.");
    }

    static void displayTicketDetails(Scanner scanner) {
        System.out.print("Enter your ticket number: ");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (Ticket ticket : tickets) {
            if (ticket.ticketNumber == ticketNumber) {
                System.out.println("Ticket Details:");
                System.out.println("Ticket Number: " + ticket.ticketNumber);
                System.out.println("Passenger Name: " + ticket.passengerName);
                System.out.println("Train Number: " + ticket.trainNumber);
                System.out.println("Seat Number: " + ticket.seatNumber);
                return;
            }
        }

        System.out.println("Ticket not found.");
    }
}
