package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @NotBlank
    @Size(min = 2, max = 50)
    private String title;
    @NotBlank
    @Size(min = 2, max = 50)
    private String author;
    @Size(min = 10, max = 255)
    private String description;
    @NotNull
    @Positive
    private BigDecimal price;

}
