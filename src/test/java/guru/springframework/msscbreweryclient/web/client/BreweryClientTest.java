package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient breweryClient;

	@Test
	void getBeerById() {
		BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto dto = BeerDto.builder().beerName("New Beer").build();
		
		URI uri = breweryClient.saveNewBeer(dto);
		
		assertNotNull(uri);
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto dto = BeerDto.builder().beerName("New Beer").build();
		
		breweryClient.updateBeer(UUID.randomUUID(), dto);
		
	}
	
	@Test
	void testDeleteBeer() {
		
		breweryClient.deleteBeer(UUID.randomUUID());
		
	}
	
	
	

}
