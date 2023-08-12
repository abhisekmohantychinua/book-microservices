package dev.abhisek.purchaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String book_id;
    private String book_name;
    private String book_author;
    private Integer book_price;
    private Integer book_count;


}
