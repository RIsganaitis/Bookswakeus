package codeAcademy.bookswakeus.books.errors;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BookNotFoundException extends RuntimeException{

    private final UUID bookId;
    public BookNotFoundException(String messageCode, UUID bookId) {
        super(messageCode);
        this.bookId = bookId;
    }
}
