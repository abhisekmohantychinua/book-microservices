package dev.abhisek.purchaseservice.dto;

import dev.abhisek.purchaseservice.entity.Book;
import dev.abhisek.purchaseservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDto {
    private Integer id;
    private User user;
    private Book book;
    private Integer quantity;
}
