import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
public class Rooms {
	static private int roomNumber= -1 ;
	//private boolean isBooked ; Removed because of task 2 !
	Set<AbstractCommodity> commodities ;
	Set<Date> maintenanceDates ;
	Set<Bookings> bookingsSet ;

	Iterator<AbstractCommodity> commodityIterator ;
	/**
	 * Constructor initializing the members of the Rooms class
	 */
	Rooms() {
		commodities = new HashSet<AbstractCommodity>();
		maintenanceDates = new HashSet<Date>();
		bookingsSet = new HashSet<Bookings>();
		initNumberOfRooms();

		roomNumber++;

	}
	int getRoomNumber(){
		return roomNumber;
	}

	/**
	 * numberOfCreatedRooms is a static member of the Rooms class
	 * it's purpose is to contain the absolute number of created rooms
	 * and thus to assist in the automatic generation ot the rooms numbers.
	 * This methods'  sole purpose is to initialize the numberOfCreatedRooms variable
	 * (if it has not been initialized ) to zero ( 0 )
	 */
	void initNumberOfRooms() {
		if(roomNumber < 0 )
			roomNumber = 0 ;
     }



	/**
	 * This method invokes all of the commodities available for the maintenance of the room.
	 * It take a Date object as a formal parameter and uses it to create a log of when the room was
	 * under maintenance.
	 * @param newMaintenanceDate
	 */
	void  roomMaintenance(Date newMaintenanceDate){
		commodityIterator = commodities.iterator();
		while(commodityIterator.hasNext()){
			commodityIterator.next().Prepare();
			maintenanceDates.add(newMaintenanceDate);
		}
	}

	/**
	 * This method takes the guest's EGN , fromDate to tell us which is the booking's starting day , and
	 * toDate to tell us which is the booking's last day.And roomToBeBooked which is used to address the room
	 * that is to be booked.
	 * It later traverses the booking set and checks whether the selected dates are already booked by checking whether the
	 * starting/end dates are already present in the booking set.
	 * @param guestEGN
	 * @param fromDate
	 * @param toDate
	 * @param roomToBeBooked
	 */
	void createBooking(String guestEGN, LocalDate fromDate, LocalDate toDate , Rooms roomToBeBooked){
		Bookings temporaryObject = new Bookings();
		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		temporaryObject.updateRoom(guestEGN,fromDate,toDate,roomToBeBooked);
		LocalDate temporaryObjectStartDate = temporaryObject.getStartDate();
		LocalDate temporaryObjectEndDate = temporaryObject.getEndDate();

		while(temporaryIterator.hasNext()){
			if(temporaryObjectStartDate.isAfter(temporaryIterator.next().getStartDate())) {
				if (temporaryObjectStartDate.isBefore(temporaryIterator.next().getEndDate())) {
					System.out.println("The Starting date of your booking is already taken.");
					return;
				}
			} else {
				if(temporaryObjectEndDate.isAfter(temporaryIterator.next().getStartDate())){
					System.out.println("The end date of your booking overlaps with another booking's days");
					return;
				}
			}
		}
		bookingsSet.add(temporaryObject);
	}

	/**
	 * An overloaded version of the upper method.The difference is that this method takes a predefined object
	 * as a parameter.
	 * It later traverses the booking set and checks whether the selected dates are already booked by checking whether
	 * the starting/end dates are already present in the booking set.
	 * @param temporaryObject
	 */
	void createBooking(Bookings temporaryObject){

		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		LocalDate temporaryObjectStartDate = temporaryObject.getStartDate();
		LocalDate temporaryObjectEndDate = temporaryObject.getEndDate();

		while(temporaryIterator.hasNext()){
			if(temporaryObjectStartDate.isAfter(temporaryIterator.next().getStartDate())) {
				if (temporaryObjectStartDate.isBefore(temporaryIterator.next().getEndDate())) {
					System.out.println("The Starting date of your booking is already taken.");
					return;
				}
			}else {
				if(temporaryObjectEndDate.isAfter(temporaryIterator.next().getStartDate())){
					System.out.println("The end date of your booking overlaps with another booking's days");
					return;
				}
			}
		}
		bookingsSet.add(temporaryObject);
	}

	/**
	 * This method removes a booking out of the booking set.
	 * It traverses the booking set and compares the dates,which have been passed as parameters , with those that are
	 * present in a member of the set.If the comparison results in a true value the set member is removed.
	 * @param fromDate
	 * @param toDate
	 */

	void removeBooking(LocalDate fromDate,LocalDate toDate ){
		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		Bookings tempBooking ;
		while(temporaryIterator.hasNext()){
			tempBooking = temporaryIterator.next();
			if(tempBooking.getStartDate().equals(fromDate) && tempBooking.getEndDate().equals(toDate)){
				temporaryIterator.remove();
			}
		}
	}

	/**
	 * Removes all of the bookings currently present in the booking set.
	 */
	void removeAllBookings(){
		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		Bookings tempBooking ;
		while ((temporaryIterator.hasNext())){
			temporaryIterator.remove();
		}
	}

	/**
	 * This method takes number of beds/showers/toilets in a single room , and adds them to the commodities.
	 * @param numberOfBeds
	 * @param numberOfShowers
	 * @param numberOfToilets
	 */
	void setCommodities(int numberOfBeds , int numberOfShowers , int numberOfToilets){
		int[] commoditiesArray = {numberOfBeds,numberOfShowers,numberOfToilets};
		while(commoditiesArray[0] > 0){
			commodities.add(new Bed());
			commoditiesArray[0] --;
		}
		while(commoditiesArray[1] > 0){
			commodities.add(new Shower());
			commoditiesArray[1] --;
		}
		while (commoditiesArray[2] > 0){
			commodities.add(new Toilet());
			commoditiesArray[2] -- ;
		}
	}
}
