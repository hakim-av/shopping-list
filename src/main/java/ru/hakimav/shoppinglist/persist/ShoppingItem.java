package ru.hakimav.shoppinglist.persist;

import javax.persistence.*;

// Данная аннотация (сущность) дает понять Spring, что этот класс для работы с базой данных. В Table название
@Entity
@Table(name = "shopping_items")

public class ShoppingItem {

    //Уникальный идентификатор покупки. Автоматическая генерация id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Настраиваем колонку name, чтобы не была пустой
    @Column(nullable = false)
    private String name;

    //Создаем конструктор
    public ShoppingItem() {
    }

    // Создаме геттеры и сеттеры для обеспечения чтения и записи в базе данных
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
