/**
 * ============================================================
 * MAIN CLASS – UseCase8BookingHistoryReport
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class demonstrates how
 * confirmed bookings are stored
 * and reported.
 *
 * The system maintains an ordered
 * audit trail of reservations.
 *
 * @version 8.0
 */

public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Booking History and Reporting");
        System.out.println();

        BookingHistory history =
                new BookingHistory();

        history.addReservation(
                new Reservation("Abhi","Single"));

        history.addReservation(
                new Reservation("Subha","Double"));

        history.addReservation(
                new Reservation("Vanmathi","Suite"));

        BookingReportService reportService =
                new BookingReportService();

        reportService.generateReport(history);

    }

}