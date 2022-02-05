package busReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
String passengerName;
int busNo;
Date date;
static int n=1;
int amountpay=150;
int amount=n*150;
Booking(){
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter name of passenger: ");
	passengerName = scanner.next();
	System.out.println("Enter bus no: ");
	busNo=scanner.nextInt();
	System.out.println("Enter date dd-mm-yyyy");
	String dateInput = scanner.next();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	System.out.println( "The amount to be  paid is:" +amountpay);
	
	
	System.out.println("Please select your payment app to pay: ");
	int app=1;
	while(app==1)
	{
		System.out.println("1.Paytm");
		System.out.println("2.Google Pay");
		System.out.println("3.PhonePe");
		int apps=scanner.nextInt();
		switch(apps) {
		case 1:
			System.out.println("Welcome to Paytm!!!!");
			break;
		case 2:
			System.out.println("Welcome to Google Pay!!!");
			break;
		case 3:
			System.out.println("Welcome to PhonePe");
			break;
		default:
		System.out.println("Not able to accessPaymode now");
		}
		break;
	}
	System.out.println("Enter the amount");
	amountpay=scanner.nextInt();
	if(amountpay==amount) {
		System.out.println("Your Payment is SUCCESSFUL");
		System.out.println("Your seat has been Successfully booked");
		
	}
	else {
		System.out.println("Your payment is failed.Please try again later");
	}
	try {
		date = dateFormat.parse(dateInput);
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
}

public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
	int capacity=0;
	for(Bus bus:buses)
	{
		if(bus.getBusNo()== busNo)
			capacity=bus.getCapacity();

	}
	int booked=0;
	for(Booking b:bookings) {
		if(b.busNo==busNo && b.date.equals(date)) {
			booked++;
		}
	}
	return booked<capacity?true:false;
}
}
