
public class Odometer {
	int mileage = 0; // starting mileage always equals 0

	public void addMileage(int miles) { // user will input parameter
		if ((mileage + miles) > 999999)
		{
			mileage += (mileage - miles); // odometer resets at 999,999 and displays the difference
		}

		else
		{
			mileage += miles;
		}
	} // end addMileage method

	public void displayMileage() { //change to toString ?
		System.out.println("You have traveled " + String.valueOf(mileage) + " miles.");
	}

}
