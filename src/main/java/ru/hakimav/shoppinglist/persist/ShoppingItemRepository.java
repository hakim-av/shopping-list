package ru.hakimav.shoppinglist.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Создается класс репозитория
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
}
