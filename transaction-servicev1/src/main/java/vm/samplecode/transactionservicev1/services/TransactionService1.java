package vm.samplecode.transactionservicev1.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vm.samplecode.transactionservicev1.dto.MonthlyTransCompDto;
import vm.samplecode.transactionservicev1.dto.TotalOutgoingDto;
import vm.samplecode.transactionservicev1.entities.Transaction;

@Service
public interface TransactionService1 {

	ResponseEntity<List<Transaction>> getAllTransaction();
	
	ResponseEntity<List<Transaction>> getAllTransactionByGivenCategory(String category);
	
	ResponseEntity<List<TotalOutgoingDto>> getTotalOutgingForAllCategory();
	
	ResponseEntity<List<MonthlyTransCompDto>> getMonthlyAvgSpendingOfGivenCategory(String category);
	
	ResponseEntity<HashMap<String, String>> getHighestSpendingByCategoryForGivenYear(String category, int year);
	
	ResponseEntity<HashMap<String, String>> getLowestSpendingByCategoryForGivenYear(String category, int year);
	
	
	
	
}
