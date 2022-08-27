package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private String description;
    private BigDecimal price;

}
