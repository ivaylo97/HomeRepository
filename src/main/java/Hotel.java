import java.util.ArrayList ;


public class Hotel {

	private String hotelName;
	public ArrayList<Rooms> listOfRooms;
	static int numberOfRooms = -1;


	Hotel() {
		hotelName = "\0"; // Or "Unnamed" ??
		listOfRooms = new ArrayList<Rooms>();
		InitNumberOfRooms();
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	void InitNumberOfRooms() {
		if (numberOfRooms < 0)
			numberOfRooms = 0;
	}


	public void addNewRoom(int idx, Rooms NewRoom) {
		listOfRooms.add(idx, NewRoom);
		numberOfRooms++;
	}


	/**
	 * Returns the Hotel's name
	 *
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}


	/**
	 * This variable is used as a new value for the Hotel Name member.
	 *
	 * @param newHotelName
	 */
	public void setHotelName(String newHotelName) {
		hotelName = newHotelName;
	}


	/**
	 * Searches the list of rooms for free ones , if there are any it returns them in an arraylist format.
	 * If none are free returns null.
	 *
	 * @return
	 */
	public ArrayList<Rooms> searchForFreeRooms() {
		boolean isNotEmpty = false;
		ArrayList<Rooms> temporaryList = new ArrayList<Rooms>();
		for (int roomCounter = 0; roomCounter < Rooms.numberOfCreatedRooms; roomCounter++) {
			if (listOfRooms.get(roomCounter).isTaken()) {
				isNotEmpty = true;
				temporaryList.add(listOfRooms.get(roomCounter));
			}
		}

		if (isNotEmpty) {
			return temporaryList;
		}else {
			return null;
		}
	}
}

