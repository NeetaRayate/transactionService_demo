package vm.samplecode.transactionservicev1.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import vm.samplecode.transactionservicev1.dto.MonthlyTransCompDto;
import vm.samplecode.transactionservicev1.dto.TotalOutgoingDto;
import vm.samplecode.transactionservicev1.entities.Transaction;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class TransactionControllerTest {

	@Autowired
	private TransactionController transactionController;

	@Test
	@DisplayName("Get All the Transaction.")
	void testGetAllTransaction() {
		ResponseEntity<List<Transaction>> allTransaction = transactionController.getAllTransaction();
		List<Transaction> expected = allTransaction.getBody();
		List<Transaction> actual = generateTransactionData();
		assertEquals(actual.get(0).getCategory(), expected.get(0).getCategory());
		assertTrue(actual.size() == expected.size());

	}

	@Test
	@DisplayName("Get All the Transaction for given category.")
	void testGetAllTransactionForGivenCategory() {
		ResponseEntity<List<Transaction>> allTransaction = transactionController
				.getAllTrasnactionForGivenCategory("MyMonthlyDD");
		List<Transaction> expected = allTransaction.getBody();
		System.out.print(expected.get(0).getVendor());

		List<Transaction> actual = generateTransactionDataForSingleCategory();
		System.out.print(actual.get(0).getVendor());

		assertEquals(actual.size(), expected.size());
	}

	@Test
	@DisplayName("Get Monthly Avg spend in a given category.")
	void testGetMonthlySpendingForGivenCategory() {
		ResponseEntity<List<MonthlyTransCompDto>> allTransaction = transactionController
				.getMonthlyAvgSpendingByCategory("MyMonthlyDD");
		List<MonthlyTransCompDto> expected = allTransaction.getBody();
		List<MonthlyTransCompDto> actual = generateMonthlySpending();
		assertEquals(actual.size(), expected.size());
	}

	@Test
	@DisplayName("Get Total Outgoing for all category.")
	void testGetTotalOutgoingForAllCategory() {
		ResponseEntity<List<TotalOutgoingDto>> allTransaction = transactionController.getTotalOutgingForAllCategory();
		List<TotalOutgoingDto> actual = allTransaction.getBody();
		List<TotalOutgoingDto> expected = generateTotalOutgoing();
		assertEquals(actual.size(), expected.size());
	}

	private List<TotalOutgoingDto> generateTotalOutgoing() {
		List<TotalOutgoingDto> outgoingData = new ArrayList<>();

		outgoingData.add(new TotalOutgoingDto("", 45.69));
		outgoingData.add(new TotalOutgoingDto("Groceries", 242.05));
		outgoingData.add(new TotalOutgoingDto("HouseHold", 130.0));
		outgoingData.add(new TotalOutgoingDto("MyMonthlyDD", 128.1));

		return outgoingData;
	}

	private List<MonthlyTransCompDto> generateMonthlySpending() {
		List<MonthlyTransCompDto> monthlySpendData = new ArrayList<>();

		monthlySpendData.add(new MonthlyTransCompDto(2, 10.0));
		monthlySpendData.add(new MonthlyTransCompDto(4, 52.84));
		monthlySpendData.add(new MonthlyTransCompDto(5, 20.69));

		return monthlySpendData;

	}

	private List<Transaction> generateTransactionDataForSingleCategory() {
		List<Transaction> transData = new ArrayList<>();

		transData.add(new Transaction(2, "2022-05-01", "GoldGym", "card", 25, "MyMonthlyDD"));
		transData.add(new Transaction(7, "2022-04-13", "H&M", "internet", 79.10, "MyMonthlyDD"));
		transData.add(new Transaction(11, "2021-02-14", "VirginMobile", "internet", 24, "MyMonthlyDD"));
		return transData;
	}

	private List<Transaction> generateTransactionData() {
		List<Transaction> transData = new ArrayList<>();

		transData.add(new Transaction(1, "2022-07-12", "Amazon", "internet", 100, "HouseHold"));
		transData.add(new Transaction(2, "2022-05-01", "GoldGym", "card", 25, "MyMonthlyDD"));
		transData.add(new Transaction(3, "2022-05-01", "Morrisons", "direct debit", 20.69, "Groceries"));
		transData.add(new Transaction(4, "2022-04-22", "Tesco", "card", 60.99, "Groceries"));
		transData.add(new Transaction(5, "2022-04-13", "Medicine", "internet", 20.69, ""));
		transData.add(new Transaction(6, "2022-04-13", "Aldi", "internet", 88.69, "Groceries"));
		transData.add(new Transaction(7, "2022-04-13", "H&M", "internet", 79.10, "MyMonthlyDD"));
		transData.add(new Transaction(8, "2022-04-01", "Tesco", "direct debit", 40.99, "Groceries"));
		transData.add(new Transaction(9, "2022-03-18", "Amazon", "internet", 30, "HouseHold"));
		transData.add(new Transaction(10, "2021-02-21", "Morrisons", "direct debit", 10, "Groceries"));
		transData.add(new Transaction(11, "2021-02-14", "VirginMobile", "internet", 24, "MyMonthlyDD"));
		transData.add(new Transaction(12, "2022-04-13", "Tesco", "internet", 20.69, "Groceries"));
		transData.add(new Transaction(13, "2022-07-04", "GoldGym", "card", 25, ""));

		return transData;
	}

}
