//import jdk.vm.ci.meta.Local;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
//Just hotfix test

public class HotelServiceApplication {
    public static void main(String[] args)
    {

        Manager Ivan = new Manager();
        Hotel transylvania = new Hotel();
        Rooms room101 = new Rooms();
        Rooms room102 = new Rooms();
        ArrayList<Rooms> tempList ;


        transylvania.setHotelName("transylvania");
        Ivan.setHotel(transylvania);
        Ivan.managedHotel = transylvania ;
        transylvania.addNewRoom(0,room101);
        transylvania.addNewRoom(1,room102);



        for(int generalPurposeCounter = 0 ,numberOfRooms = transylvania.getNumberOfRooms();  generalPurposeCounter < numberOfRooms ; generalPurposeCounter ++ ) {
            Ivan.managedHotel.listOfRooms.get(generalPurposeCounter).removeAllBookings();
        }

/*
       LocalDate test = LocalDate.parse("2000-10-25");
       LocalDate testComparison = LocalDate.parse("2000-10-25");
       LocalDate testComparison2 = LocalDate.parse("2001-10-25");
       if(test.equals(testComparison)){
       	System.out.println(testComparison);
	   }
       if(testComparison.isBefore(testComparison2)){
       	System.out.println(testComparison+"is before"+testComparison2);
	   }
*/
    }

}
