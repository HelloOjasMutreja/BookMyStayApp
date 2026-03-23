/**
 * ============================================================
 * MAIN CLASS – UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */

public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        AddOnServiceManager manager =
                new AddOnServiceManager();

        AddOnService breakfast =
                new AddOnService("Breakfast",500);

        AddOnService spa =
                new AddOnService("Spa",1000);

        manager.addService(
                reservationId,
                breakfast);

        manager.addService(
                reservationId,
                spa);

        double total =
                manager.calculateTotalServiceCost(
                        reservationId);

        System.out.println(
                "Reservation ID: "
                        + reservationId);

        System.out.println(
                "Total Add-On Cost: "
                        + total);

    }

}