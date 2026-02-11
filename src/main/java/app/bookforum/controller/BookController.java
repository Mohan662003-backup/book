package app.bookforum.controller;

import app.bookforum.models.Book;
import app.bookforum.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add-book")
    public ResponseEntity<Void> addBook(@Valid @RequestBody Book book){

        bookService.addBook(book);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable int bookId){
        Book book = bookService.getBook(bookId);
        return book != null
                ? ResponseEntity.ok(book)
                : ResponseEntity.noContent().build();
    }
}
