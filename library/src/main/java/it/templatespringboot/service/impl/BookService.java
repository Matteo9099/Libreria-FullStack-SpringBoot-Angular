package it.templatespringboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import it.templatespringboot.exception.CustomNotFoundException;

import it.templatespringboot.domain.Book;
import it.templatespringboot.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService implements ICrudService<Book, String>{
	
	private final BookRepository repository;
	
	public BookService(final BookRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Book> findAll() {
		log.info("Begin findAll");
		List<Book> response = repository.findAll();
		log.info("End findAll - response: {}", response);
		return response;
	}

	@Override
	public Book get(String id) {
		log.info("Begin get - id: {}", id);
		Optional<Book> book = repository.findById(id);
		if(book.isPresent()) {
			log.info("Eng get");
			return book.get();
		} else {
			throw new CustomNotFoundException("id: " + id);
		}
	}

	@Override
	public String create(Book dto) {
		log.info("Begin create - dto: {}", dto);
		String id = repository.save(dto).getId();
		log.info("End create - id: {}", id);
		return id;
	}

	@Override
	public void update(String id, Book dto) {
		log.info("Begin update - id: {} dto: {}", id, dto);
		Optional<Book> utenteOpt = repository.findById(id);
		if(utenteOpt.isPresent()) {
			utenteOpt.get().getId();
			repository.save(utenteOpt.get());
			log.info("End get - update");
		} else {
			throw new CustomNotFoundException("id: " + id);
		}
	}

	@Override
	public void delete(String id) {
		log.info("Begin delete - id: {}", id);
		Optional<Book> utenteOpt = repository.findById(id);
		if(utenteOpt.isPresent()) {
			repository.deleteById(id);
			log.info("End delete");
		} else {
			throw new CustomNotFoundException("id: " + id);
		}
	}

}
