/**
 * ============================================================
 * MAIN CLASS – UseCase6RoomAllocation
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 * @version 6.0
 */

public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory =
                new RoomInventory();

        BookingRequestQueue queue =
                new BookingRequestQueue();

        RoomAllocationService allocator =
                new RoomAllocationService();

        queue.addRequest(
                new Reservation("Abhi","Single"));

        queue.addRequest(
                new Reservation("Subha","Single"));

        queue.addRequest(
                new Reservation("Vanmathi","Suite"));

        while(queue.hasPendingRequests()){

            Reservation r =
                    queue.getNextRequest();

            allocator.allocateRoom(
                    r,
                    inventory);

        }

    }

}