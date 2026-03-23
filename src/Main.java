import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS – UseCase9ErrorHandlingValidation
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class demonstrates how user input
 * is validated before booking is processed.
 *
 * The system:
 * - Accepts user input
 * - Validates input centrally
 * - Handles errors gracefully
 *
 * @version 9.0
 */

public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner =
                new Scanner(System.in);

        RoomInventory inventory =
                new RoomInventory();

        ReservationValidator validator =
                new ReservationValidator();

        BookingRequestQueue bookingQueue =
                new BookingRequestQueue();

        try{

            System.out.print(
                    "Enter guest name: ");

            String guestName =
                    scanner.nextLine();

            System.out.print(
                    "Enter room type (Single/Double/Suite): ");

            String roomType =
                    scanner.nextLine();

            validator.validate(
                    guestName,
                    roomType,
                    inventory);

            Reservation reservation =
                    new Reservation(
                            guestName,
                            roomType);

            bookingQueue.addRequest(
                    reservation);

            System.out.println(
                    "Booking request accepted.");

        }
        catch(InvalidBookingException e){

            System.out.println(
                    "Booking failed: "
                            + e.getMessage());

        }
        finally{

            scanner.close();

        }

    }

}