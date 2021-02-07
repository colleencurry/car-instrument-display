import javax.swing.JOptionPane;

/**
 * This program simulates driving and refueling a vehicle.
 * @author Colleen Curry
 * Class: CISS 111, Section 300
 */

public class InstrumentDisplay {
	
	static boolean driving = true;
	static int milesSinceLastGas = 0; // miles since user last refueled
	static double cruisingRange = 420.0; // distance user can drive before refueling; assumes 28 miles/gallon and 15 gallons at start
	
	static FuelGauge f = new FuelGauge();
	static Odometer o = new Odometer();

	public static void main(String[] args) {

		System.out.println("Time for a road trip. Hop in and buckle up!");

		while (driving == true) {

			System.out.print("\n");
			f.displayFuel();
			o.displayMileage();
			System.out.println("Your cruising range is " + String.valueOf((int)cruisingRange) + " miles.");
			System.out.println("You've traveled " + String.valueOf((int)milesSinceLastGas) + " miles since you last filled up the tank.");
			

			int userInput = Integer.parseInt(JOptionPane.showInputDialog("\nPlease select from the following controls:" + 
					" \nPress 1 to drive." +
					" \nPress 2 to fill the tank." +
					" \nPress 3 to exit the car."));
			
			if (userInput == 3 && o.mileage == 0)
			{	
				System.out.print("\nGood choice. Walking is better for the environment, anyway.");
				driving = false; //ends the driving while loop
			} else if (userInput == 3)
			{
				System.out.println("\nYou have arrived at your destination.");
				driving = false; //ends the driving while loop
			} else {
				drive(userInput);
			}
			

		} //end driving while loop

	} // end main loop	
		
	public static void drive(int num) {

		switch(num) {
		
			case 1:
				int numMiles = Integer.parseInt(JOptionPane.showInputDialog("How many miles should we drive?"));
					if (numMiles <= cruisingRange) {
						f.useFuel(numMiles); // subtracts fuel from the tank
						o.addMileage(numMiles); // increments the odometer
						milesSinceLastGas += numMiles; 
						cruisingRange -= numMiles;
					} else
						{int doInstead = Integer.parseInt(JOptionPane.showInputDialog("Sorry, but you can only drive " + String.valueOf((int)cruisingRange) + " miles." + 
																	" \nPress 1 to drive a smaller distance." +
																	" \nPress 2 to fill the tank instead."));
						switch(doInstead) {

							case 1:
								drive(1);
								break;

							case 2:
								drive(2);
								break;

						} //end switch(doInstead)
					} // end else
				break;

			case 2:
				double startingFuel = f.gallons;
				f.addFuel();
				cruisingRange = (28.0 * f.gallons);
				if (f.gallons > startingFuel) { // if gas has been added to the tank
					milesSinceLastGas = 0; // resets counter to zero
				}
				break;

			default:
				System.out.println("Invalid command. Please select from the following controls: " + 
														" \nPress 1 to drive." +
														" \nPress 2 to fill the tank." +
														" \nPress 3 to exit the car.");
		} // end switch(input) 		

	} // end drive
	
} // end InstrumentDisplay