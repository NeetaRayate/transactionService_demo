package vm.samplecode.transactionservicev1.dto;

public class MonthlyTransCompDto {

	private int month;
	private double avgSpending;


	public MonthlyTransCompDto(int month, double avgSpending) {
		super();
		this.month = month;
		this.avgSpending = avgSpending;
	}

	public MonthlyTransCompDto() {
		// TODO Auto-generated constructor stub
	}

	public double getAvgSpending() {
		return avgSpending;
	}

	public void setAvgSpending(double avgSpending) {
		this.avgSpending = avgSpending;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
