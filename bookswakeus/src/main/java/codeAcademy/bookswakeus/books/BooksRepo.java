package codeAcademy.bookswakeus.books;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Repository
public class BooksRepo {


    public List<Book> getBooks(){
        return Collections.singletonList(new Book("book1", "author1",
                "description", new BigDecimal("1.5")));
    }

}
