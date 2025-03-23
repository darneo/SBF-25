package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository repository;

    // Конструктор с инъекцией зависимости
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    @Operation(summary="вадлытвпав")
    public Book findById(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found: id=" + id));
    }

    @GetMapping
    public List<Book> findAll() {
        return repository.getBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }
}
