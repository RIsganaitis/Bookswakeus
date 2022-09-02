package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private UUID id;
    private String title;
    private String author;
    private String description;
    private BigDecimal price;

}
