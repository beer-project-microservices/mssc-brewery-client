package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
class CustomerClientTest {

	@Autowired
	CustomerClient customerClient;

	@Test
	void getBeerById() {
		CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		CustomerDto dto = CustomerDto.builder().name("New Customer").build();
		
		URI uri = customerClient.saveNewCustomer(dto);
		
		assertNotNull(uri);
	}
	
	@Test
	void testUpdateBeer() {
		CustomerDto dto = CustomerDto.builder().name("New Customer").build();
		
		customerClient.updateCustomer(UUID.randomUUID(), dto);
		
	}
	
	@Test
	void testDeleteBeer() {
		
		customerClient.deleteCustomer(UUID.randomUUID());
		
	}
}
