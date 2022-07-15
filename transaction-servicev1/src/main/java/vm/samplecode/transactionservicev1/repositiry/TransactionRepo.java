package vm.samplecode.transactionservicev1.repositiry;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vm.samplecode.transactionservicev1.entities.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	List<Transaction> findAll(Sort desc);

	// All transaction for a given category.
	@Query("SELECT t FROM Transaction t WHERE t.category = :c order by t.transactionDate desc")
	List<Transaction> findAllTransactionForGivenCategory(@Param("c") String category);

	// total outgoing per category
	@Query("SELECT t.category, SUM(t.amount) from Transaction t group by t.category")
	List<Object[]> findTotalOutgoingForAllCategory();

	// Monthly average spend in a given category
	@Query("SELECT t.category, Month(t.transactionDate), AVG(t.amount) from Transaction t WHERE t.category = :c group by Month(t.transactionDate)")
	List<Object[]> findMonthlyAvgSpendingofGivenCategory(@Param("c") String category);

	// Highest spend in a given category for a given year
	@Query("SELECT t.category, MAX(t.amount) from Transaction t WHERE t.category = :c AND Year(t.transactionDate) = :y group by Year(t.transactionDate)")
	List<Object[]> findHighestSpendingForGivenCategory(@Param("c") String category, @Param("y") int year);

	// lowest spend in a given category for a given year
	@Query("SELECT t.category, MIN(t.amount) from Transaction t WHERE t.category = :c AND Year(t.transactionDate) = :y group by Year(t.transactionDate)")
	List<Object[]> findLowestSpendingForGivenCategory(@Param("c") String category, @Param("y") int year);

}
