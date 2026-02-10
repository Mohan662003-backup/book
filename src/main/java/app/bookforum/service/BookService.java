package app.bookforum.service;

import app.bookforum.models.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {

    private final Map<Integer, Book> books;
    private final AtomicInteger idGenerator;

    public BookService(){
        this.idGenerator = new AtomicInteger(1);
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        int bookId = idGenerator.getAndIncrement();
        book.setBookId(bookId);

        books.put(bookId, book);
    }

    public Book getBook(int bookId) {
        return books.getOrDefault(bookId, null);
    }
}
