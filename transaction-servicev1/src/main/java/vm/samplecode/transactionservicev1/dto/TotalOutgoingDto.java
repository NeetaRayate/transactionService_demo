package vm.samplecode.transactionservicev1.dto;

public class TotalOutgoingDto {

	private String category;
	private double totalSpending;

	public TotalOutgoingDto() {
		
	}
	public TotalOutgoingDto(String string, double d) {
		// TODO Auto-generated constructor stub
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getTotalSpending() {
		return totalSpending;
	}

	public void setTotalSpending(double totalSpending) {
		this.totalSpending = totalSpending;
	}
}
