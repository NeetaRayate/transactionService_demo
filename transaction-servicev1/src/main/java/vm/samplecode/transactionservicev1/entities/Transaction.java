package vm.samplecode.transactionservicev1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "ID")
	private Integer id;

	@Column(name = "Transaction_date")
	private String transactionDate;

	@Column(name = "Vendor")
	private String vendor;

	@Column(name = "Type")
	private String type;

	@Column(name = "Amount")
	private double amount;

	@Column(name = "Category")
	private String category;

	public Transaction(Integer id, String transactionDate, String vendor, String type, double d, String category) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.vendor = vendor;
		this.type = type;
		this.amount = d;
		this.category = category;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
