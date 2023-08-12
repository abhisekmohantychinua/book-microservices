package dev.abhisek.purchaseservice.repository;

import dev.abhisek.purchaseservice.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    List<Purchase> findAllByUserId(Integer userId);

    List<Purchase> findAllByBookId(String bookId);
}
