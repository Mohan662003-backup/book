package app.bookforum.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    private Integer bookId;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 200)
    private String title;
    @NotBlank(message = "Author is required")
    @Size(min = 2, max = 100)
    private String author;

    @Size(max = 1000)
    private String description;
    @NotBlank(message = "Category is required")
    @Size(max = 100)
    private String category;



}
