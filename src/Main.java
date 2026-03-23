/**
 * ============================================================
 * MAIN CLASS – UseCase12DataPersistenceRecovery
 * ============================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class demonstrates how system state
 * can be restored after an application restart.
 *
 * Inventory data is loaded from a file
 * before any booking operations occur.
 *
 * @version 12.0
 */

public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory =
                new RoomInventory();

        FilePersistenceService persistence =
                new FilePersistenceService();

        String filePath = "inventory.txt";

        persistence.loadInventory(
                inventory,
                filePath);

        System.out.println();
        System.out.println("Current Inventory:");

        System.out.println(
                "Single: "
                        + inventory.getRoomAvailability()
                        .get("Single"));

        System.out.println(
                "Double: "
                        + inventory.getRoomAvailability()
                        .get("Double"));

        System.out.println(
                "Suite: "
                        + inventory.getRoomAvailability()
                        .get("Suite"));

        persistence.saveInventory(
                inventory,
                filePath);

    }

}