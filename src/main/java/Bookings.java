import java.time.*;
public class Bookings {
	private LocalDate startDate ;
	private LocalDate endDate ;
	private Rooms bookedRoom ;
	private String guestEGN;


	Bookings(){
		startDate = null ;
		endDate = null ;
		bookedRoom = null ;
		guestEGN = "" ;
	}
	Bookings(String EGN, LocalDate newStartDate, LocalDate newEndDate , Rooms roomToBeBooked) {
		if(EGN.length()<10){
				System.out.println("Invalid EGN.");
		} else {
			guestEGN = EGN ;
		}
		if(startDate.toString() == ""){
			System.out.println("Invalid  start date.");
		} else {
			startDate = newStartDate ;
		}
		if(endDate.toString() == ""){
			System.out.println("Invalid end date");
		} else {
			endDate = newEndDate ;
		}
		if(roomToBeBooked == null){
			System.out.println("Invalid room");
		} else {
			bookedRoom = roomToBeBooked ;
		}
	}

	/**
	 * This method takes the listed parameters below and uses them to initialize the class' members.
	 * @param newGuestEGN
	 * @param newStartDate
	 * @param newEndDate
	 * @param newBookedRoom
	 */

	public void updateRoom(String newGuestEGN, LocalDate newStartDate, LocalDate newEndDate , Rooms newBookedRoom) {
		startDate = newStartDate ;
		endDate = newEndDate ;
		bookedRoom = newBookedRoom ;
		guestEGN = newGuestEGN ;
	}

	/**
	 * When invoked this method returns the booking's start date.
	 * @return startDate
	 */
	public LocalDate getStartDate(){
		return startDate ;
	}

	/**
	 * When invoked this method returns the booking's end date.
	 * @return endDate
	 */
	public LocalDate getEndDate(){
		return  endDate ;
	}
}
