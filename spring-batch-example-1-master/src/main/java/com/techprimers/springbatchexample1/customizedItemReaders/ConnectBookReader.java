package com.techprimers.springbatchexample1.customizedItemReaders;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techprimers.springbatchexample1.dto.ConnectBooksResponseDTO;

/**
 * This  class is Incomplete at time of this demo transfer to 
 * @author abharsa
 *
 */
public class ConnectBookReader implements ItemReader<ConnectBooksResponseDTO> {

	private String apiUrl = null; // contains the URL of the external REST API.
	private RestTemplate restTemplate = null; // ref. to the RestTemplate, so as to fetch the user information.

	private int nextStudentIndex; // index of the next StudentDTO object.
	private List<ConnectBooksResponseDTO> bookList; // list of user objects obtained from ReST API

	public ConnectBookReader(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		nextStudentIndex = 0;
	}

	@Override
	public ConnectBooksResponseDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (isBookDataNotInitialized()) {
			bookList = this.fetchBooksFromConnectAPI();
		}

		ConnectBooksResponseDTO nextBook = null;

		if (nextStudentIndex < bookList.size()) {
			nextBook = bookList.get(nextStudentIndex);
			nextStudentIndex++;
		}

		return nextBook;
	}

	private boolean isBookDataNotInitialized() {
		return (this.bookList == null);
	}

	private List<ConnectBooksResponseDTO> fetchBooksFromConnectAPI() {
		ResponseEntity<ConnectBooksResponseDTO[]> response = restTemplate.getForEntity(apiUrl, ConnectBooksResponseDTO[].class);
		ConnectBooksResponseDTO[] connectBooksDataArray = response.getBody();
		return Arrays.asList(connectBooksDataArray);
	}

}
