package lt.eif.viko.l.mackevicius.BookStoreClient;

import lt.eif.viko.l.mackevicius.BookStoreClient.config.PortService;
import lt.eif.viko.l.mackevicius.BookStoreClient.config.ServicePort;
import lt.eif.viko.l.mackevicius.BookStoreClient.generated_class.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookStoreClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreClientApplication.class, args);

		PortService service = new PortService();
		ServicePort port = service.getPortServiceSoap11();

		GetAllBookRequest request = new GetAllBookRequest();
		GetAllBookResponse response = port.getAllBook(request);

		List<Book> books = new ArrayList<>();
		books.addAll(response.getAllBooks());
		for(Book book: books){
			System.out.println(book.toString());
		}

		GetCustomerRequest request1 = new GetCustomerRequest();
		request1.setId(1);
		GetCustomerResponse response1 = port.getCustomer(request1);
		System.out.println(response1.getCustomer().toString());

		GetBookOrderRequest request2 = new GetBookOrderRequest();
		request2.setId(1);
		GetBookOrderResponse response2 = port.getBookOrder(request2);
		System.out.println(response2.getOrder().toString());

	}

}
