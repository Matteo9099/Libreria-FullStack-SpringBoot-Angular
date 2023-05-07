package it.templatespringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import it.templatespringboot.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>{
	

}
