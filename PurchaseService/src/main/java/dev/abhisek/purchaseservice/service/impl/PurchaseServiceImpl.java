package dev.abhisek.purchaseservice.service.impl;

import dev.abhisek.purchaseservice.dto.PurchaseDto;
import dev.abhisek.purchaseservice.entity.Book;
import dev.abhisek.purchaseservice.entity.Purchase;
import dev.abhisek.purchaseservice.repository.PurchaseRepository;
import dev.abhisek.purchaseservice.service.PurchaseService;
import dev.abhisek.purchaseservice.service.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final UserClient userClient;
    private final RestTemplate restTemplate;
    private final PurchaseRepository purchaseRepository;

    private PurchaseDto entityToDto(Purchase purchase) {
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setId(purchase.getId());
        purchaseDto.setQuantity(purchase.getQuantity());
        purchaseDto.setUser(userClient.getUserById(purchase.getUserId()));
        Book book = restTemplate.getForObject("http://localhost:8000/api/" + purchase.getBookId(), Book.class);
        purchaseDto.setBook(book);
        return purchaseDto;
    }

    @Override
    public PurchaseDto addPurchase(Purchase purchase) {
        return entityToDto(purchaseRepository.save(purchase));
    }

    @Override
    public List<PurchaseDto> getAllPurchase() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public PurchaseDto getPurchaseById(Integer id) {
        Purchase purchase = purchaseRepository
                .findById(id)
                .orElseThrow();
        return entityToDto(purchase);
    }

    @Override
    public List<PurchaseDto> getAllPurchaseByUserId(Integer userId) {
        List<Purchase> purchases = purchaseRepository
                .findAllByUserId(userId);
        return purchases
                .stream()
                .map(this::entityToDto)
                .toList();

    }

    @Override
    public List<PurchaseDto> getAllPurchaseByBookId(String book_id) {
        List<Purchase> purchases = purchaseRepository
                .findAllByBookId(book_id);
        return purchases
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public void deletePurchase(Integer id) {
        purchaseRepository.deleteById(id);
    }
}
