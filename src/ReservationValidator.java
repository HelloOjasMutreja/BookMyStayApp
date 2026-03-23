/**
 * ============================================================
 * CLASS – ReservationValidator
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class is responsible for validating
 * booking requests before they are processed.
 *
 * All validation rules are centralized
 * to avoid duplication and inconsistency.
 *
 * @version 9.0
 */

public class ReservationValidator {

    /**
     * Validates booking input provided by the user.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        if(guestName == null || guestName.trim().isEmpty()){

            throw new InvalidBookingException(
                    "Guest name cannot be empty.");

        }

        if(!inventory.getRoomAvailability()
                .containsKey(roomType)){

            throw new InvalidBookingException(
                    "Invalid room type selected.");

        }

        int available =
                inventory.getRoomAvailability()
                        .get(roomType);

        if(available <= 0){

            throw new InvalidBookingException(
                    "No rooms available for selected type.");

        }

    }

}