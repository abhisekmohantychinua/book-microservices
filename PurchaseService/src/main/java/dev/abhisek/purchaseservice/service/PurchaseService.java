package dev.abhisek.purchaseservice.service;

import dev.abhisek.purchaseservice.dto.PurchaseDto;
import dev.abhisek.purchaseservice.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    PurchaseDto addPurchase(Purchase purchase);

    List<PurchaseDto> getAllPurchase();

    PurchaseDto getPurchaseById(Integer id);

    List<PurchaseDto> getAllPurchaseByUserId(Integer userId);

    List<PurchaseDto> getAllPurchaseByBookId(String book_id);

    void deletePurchase(Integer id);
}
