package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anuallncome, Double healthExpenditures) {
		super(name, anuallncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		if (getAnuallncome() < 20000.00) {
			return (getAnuallncome() * 0.15) - (getHealthExpenditures() * 0.50);
		} else {
			return (getAnuallncome() * 0.25) - (getHealthExpenditures() * 0.50);
		}
	}

}
