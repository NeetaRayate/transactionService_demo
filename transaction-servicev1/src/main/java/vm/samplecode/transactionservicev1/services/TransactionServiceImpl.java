package vm.samplecode.transactionservicev1.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import vm.samplecode.transactionservicev1.dto.MonthlyTransCompDto;
import vm.samplecode.transactionservicev1.dto.TotalOutgoingDto;
import vm.samplecode.transactionservicev1.entities.Transaction;
import vm.samplecode.transactionservicev1.repositiry.TransactionRepo;

//class has implementation of all REST request
@Component
public class TransactionServiceImpl implements TransactionService1 {

	@Autowired
	TransactionRepo transactionRepo;

	/**
	 * Method to get transaction history
	 */
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		try {
			List<Transaction> list = transactionRepo.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method to get Transaction history for a given category.
	 */
	@Override
	public ResponseEntity<List<Transaction>> getAllTransactionByGivenCategory(String category) {
		try {
			List<Transaction> list = transactionRepo.findAllTransactionForGivenCategory(category);

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method to get the total outgoing for all category.
	 */
	@Override
	public ResponseEntity<List<TotalOutgoingDto>> getTotalOutgingForAllCategory() {
		try {
			List<Object[]> objList = transactionRepo.findTotalOutgoingForAllCategory();

			if (objList.isEmpty() || objList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			List<TotalOutgoingDto> list = new ArrayList<>();
			for (Object[] ob : objList) {
				TotalOutgoingDto dto = new TotalOutgoingDto();
				dto.setCategory((String) ob[0]);
				dto.setTotalSpending((double) ob[1]);
				list.add(dto);
			}
			return new ResponseEntity<List<TotalOutgoingDto>>(list, HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method to get month wise average spending for given category. 
	 */
	@Override
	public ResponseEntity<List<MonthlyTransCompDto>> getMonthlyAvgSpendingOfGivenCategory(String category) {
		try {
			List<Object[]> objList = transactionRepo.findMonthlyAvgSpendingofGivenCategory(category);

			if (objList.isEmpty() || objList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			List<MonthlyTransCompDto> list = new ArrayList<>();
			for (Object[] ob : objList) {
				MonthlyTransCompDto dto = new MonthlyTransCompDto();
				// dto.setCategory((String) ob[0]);
				dto.setMonth((int) ob[1]);
				dto.setAvgSpending((double) ob[2]);
				list.add(dto);
			}
			return new ResponseEntity<List<MonthlyTransCompDto>>(list, HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method to get Highest amount spend for a given category in the given year.
	 */
	@Override
	public ResponseEntity<HashMap<String, String>> getHighestSpendingByCategoryForGivenYear(String category, int year) {
		try {
			// validate year
			String regex = "20[0-9][0-9]";
			if (!Pattern.matches(regex, "" + year)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			List<Object[]> objList = transactionRepo.findHighestSpendingForGivenCategory(category, year);

			if (objList.isEmpty() || objList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			HashMap<String, String> map = new HashMap<>();

			for (Object[] ob : objList) {
				map.put("year", "" + year);
				//map.put("category", (String) ob[0]);
				map.put("HighestSpending", "" + ob[1]);
				;
			}
			return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<HashMap<String,String>>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Method to get lowest amount spend for a given category in the given year.
	 */
	@Override
	public ResponseEntity<HashMap<String, String>> getLowestSpendingByCategoryForGivenYear(String category, int year) {
		try {
			// validate year
			String regex = "20[0-9][0-9]";
			if (!Pattern.matches(regex, "" + year)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			List<Object[]> objList = transactionRepo.findLowestSpendingForGivenCategory(category, year);

			if (objList.isEmpty() || objList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			HashMap<String, String> map = new HashMap<>();

			for (Object[] ob : objList) {
				map.put("year", "" + year);
				//map.put("category", (String) ob[0]);
				map.put("LowestSpending", "" + ob[1]);
				;
			}
			return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<HashMap<String,String>>(HttpStatus.BAD_REQUEST);

		}
	}

}
