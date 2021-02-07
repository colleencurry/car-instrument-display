import javax.swing.JOptionPane;
public class FuelGauge {
	
	public double gallons = 15.0;

	public void displayFuel() {
		System.out.println("Right now, there are " + String.valueOf((int)gallons) + " gallons of gas in the tank."); //prints the number of gallons currently in the tank
	}

	public void addFuel() {
		if (gallons <= 14.0)
		{
			int fuelAmount = Integer.parseInt(JOptionPane.showInputDialog("Do you want to add 1 gallon or top it off?" + 
											" \nPress 1 to add 1 gallon." +
											" \nPress 2 to top it off."));
			switch(fuelAmount) {
				
					case 1:
						gallons += 1;
						break;
						
					case 2:
						topItOff();
						break;
			} //end switch
		} else if (gallons < 15) 
		{
			System.out.println("\nThe tank is already pretty full, so we'll just top it off.");
			topItOff();
		} else {
			System.out.println("\nThe tank is already full.");
		} //end else
	}

	public void topItOff() {
		
		double amountEmpty = (15.0 - gallons); // gets the difference between gas in the tank and full tank
		gallons += amountEmpty; // adds the difference to the tank to top it off
		
	}

	public void useFuel(int miles) {
		gallons -= ((miles) * (1.0 / 28.0));
	}
}
