package dev.abhisek.purchaseservice.controller;

import dev.abhisek.purchaseservice.dto.PurchaseDto;
import dev.abhisek.purchaseservice.entity.Purchase;
import dev.abhisek.purchaseservice.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseDto> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity
                .ok(purchaseService.addPurchase(purchase));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAllPurchase() {
        return ResponseEntity
                .ok(purchaseService.getAllPurchase());
    }

    @GetMapping("{id}")
    public ResponseEntity<PurchaseDto> getPurchaseById(@PathVariable Integer id) {
        return ResponseEntity
                .ok(purchaseService.getPurchaseById(id));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<PurchaseDto>> getPurchaseByUserId(@PathVariable Integer userId) {
        return ResponseEntity
                .ok(purchaseService.getAllPurchaseByUserId(userId));
    }

    @GetMapping("book/{book_id}")
    public ResponseEntity<List<PurchaseDto>> getPurchaseByBookId(@PathVariable String book_id) {
        return ResponseEntity
                .ok(purchaseService.getAllPurchaseByBookId(book_id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePurchase(@PathVariable Integer id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
