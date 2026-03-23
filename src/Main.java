/**
 * ============================================================
 * MAIN CLASS – UseCase10BookingCancellation
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */

public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory =
                new RoomInventory();

        CancellationService cancellationService =
                new CancellationService();

        String reservationId = "Single-1";

        cancellationService.registerBooking(
                reservationId,
                "Single");

        cancellationService.cancelBooking(
                reservationId,
                inventory);

        cancellationService.showRollbackHistory();

        System.out.println();

        System.out.println(
                "Updated Single Room Availability: "
                        + inventory.getRoomAvailability()
                        .get("Single"));

    }

}