package vm.samplecode.transactionservicev1.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vm.samplecode.transactionservicev1.dto.MonthlyTransCompDto;
import vm.samplecode.transactionservicev1.dto.TotalOutgoingDto;
import vm.samplecode.transactionservicev1.entities.Transaction;
import vm.samplecode.transactionservicev1.services.TransactionService1;

@RestController
@RequestMapping("/rest/v1/transaction")
public class TransactionController {

	@Autowired
	TransactionService1 transService;


	@GetMapping("/")
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		return this.transService.getAllTransaction();
	}
	
	@GetMapping("/categorywise")
	public ResponseEntity<List<Transaction>> getAllTrasnactionForGivenCategory(
			@RequestParam(name = "category", required = true) String category) {
		return this.transService.getAllTransactionByGivenCategory(category);
	}

	@GetMapping("/totaloutgoing")
	public ResponseEntity<List<TotalOutgoingDto>> getTotalOutgingForAllCategory() {
		return this.transService.getTotalOutgingForAllCategory();
	}

	@GetMapping("/avgspending")
	public ResponseEntity<List<MonthlyTransCompDto>> getMonthlyAvgSpendingByCategory(
			@RequestParam(name = "category", required = true) String category) {
		return transService.getMonthlyAvgSpendingOfGivenCategory(category);
	}

	@GetMapping("/highspending")
	public ResponseEntity<HashMap<String, String>> getHighestSpendingByCategoryForGivenYear(
			@RequestParam(name = "category", required = true) String category,
			@RequestParam(name = "year", required = true) int year) {
		return transService.getHighestSpendingByCategoryForGivenYear(category, year);
	}

	@GetMapping("/lowspending")
	public ResponseEntity<HashMap<String, String>> getLowestSpendingByCategoryForGivenYear(
			@RequestParam(name = "category", required = true) String category,
			@RequestParam(name = "year", required = true) int year) {
		return transService.getLowestSpendingByCategoryForGivenYear(category, year);
	}

}
