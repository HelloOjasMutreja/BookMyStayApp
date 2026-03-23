import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ============================================================
 * CLASS – CancellationService
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class is responsible for handling
 * booking cancellations.
 *
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 *
 * A stack is used to model rollback behavior.
 *
 * @version 10.0
 */

public class CancellationService {

    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID to room type. */
    private Map<String,String> reservationRoomTypeMap;

    /** Initializes cancellation tracking structures. */
    public CancellationService(){

        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();

    }

    /**
     * Registers a confirmed booking.
     *
     * This method simulates storing confirmation
     * data that will later be required for cancellation.
     *
     * @param reservationId confirmed reservation ID
     * @param roomType allocated room type
     */
    public void registerBooking(
            String reservationId,
            String roomType){

        reservationRoomTypeMap.put(
                reservationId,
                roomType);

    }

    /**
     * Cancels a confirmed booking and
     * restores inventory safely.
     *
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(
            String reservationId,
            RoomInventory inventory){

        if(!reservationRoomTypeMap
                .containsKey(reservationId)){

            System.out.println(
                    "Invalid reservation ID.");

            return;

        }

        String roomType =
                reservationRoomTypeMap
                        .get(reservationId);

        releasedRoomIds.push(reservationId);

        int available =
                inventory.getRoomAvailability()
                        .get(roomType);

        inventory.updateAvailability(
                roomType,
                available + 1);

        reservationRoomTypeMap
                .remove(reservationId);

        System.out.println(
                "Booking cancelled successfully. "
                        + "Inventory restored for room type: "
                        + roomType);

    }

    /**
     * Displays recently cancelled reservations.
     *
     * This method helps visualize rollback order.
     */
    public void showRollbackHistory(){

        System.out.println();
        System.out.println(
                "Rollback History (Most Recent First):");

        while(!releasedRoomIds.isEmpty()){

            System.out.println(
                    "Released Reservation ID: "
                            + releasedRoomIds.pop());

        }

    }

}