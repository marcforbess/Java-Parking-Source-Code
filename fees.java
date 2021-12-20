
public class fees {
	private double fees;
	private final double afterThree = 1.50;
	
	public void calculateFees(double selectedInHour, double selectedInMinutes, double selectedOutHour, double selectedOutMinutes) {
		double startDuration = selectedInHour + (selectedInMinutes/60);
		double endDuration =  selectedOutHour + (selectedOutMinutes/60);
		double parkingDuration = Math.ceil(endDuration - startDuration);
		if(parkingDuration<=3) {
			this.fees = 3;
		}else if(parkingDuration>3) {
			this.fees = (3 + ((parkingDuration-3) * this.afterThree));
		}
		
	}
	
	public double getFees() {
		return this.fees;
	}
}
