package vm.samplecode.transactionservicev1.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionTest {

	@Test
	void testTransactionEntity() {
		final Transaction transEntity = new Transaction();
        transEntity.setId(1);
        transEntity.setAmount(10);
        transEntity.setCategory("Groceries");
        transEntity.setTransactionDate("1/1/2022");
        transEntity.setType("card");
        transEntity.setVendor("Tesco");
        
        assertEquals(10, transEntity.getAmount());
        assertEquals("Groceries", transEntity.getCategory());
        assertEquals("card", transEntity.getType());
	}

}
