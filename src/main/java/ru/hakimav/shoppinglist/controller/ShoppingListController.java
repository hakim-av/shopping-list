package ru.hakimav.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hakimav.shoppinglist.persist.ShoppingItem;
import ru.hakimav.shoppinglist.persist.ShoppingItemRepository;

// Чтобы Спринг понял что это контроллер
@Controller
public class ShoppingListController {

    private final ShoppingItemRepository repository;

    // Находит repository и передает его
    @Autowired
    public ShoppingListController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    // Данный метод срабатывает если отправили такой запрос (GetMapping)
    // Отображает нашу основную страницу. Объект класса model нужна чтобы из контроллера выдали в представление
    @GetMapping
    public String indexPage(Model model) {

        model.addAttribute("items", repository.findAll()); // Выводи уже добавленные покупки
        model.addAttribute("item", new ShoppingItem()); // Первое отображение (пустой экземпляр)

    return "index"; // Возвращаем то представление, которое хотим отобразить (index.html)
    }

    //Данный метод срабатывает при добавлении нового дела в список
    @PostMapping
    public String newShoppingItem (ShoppingItem item) {
        repository.save(item); // Сохраняет новое в репозиторий
        return "redirect:/"; // Обновляет страницу браузера, чтобы показать новые дела
    }

    //Удаляем ненужный пункт.
    @DeleteMapping("/{id}")
    public String deleteShoppingItem (@PathVariable Long id) { // PathVariable добавляет необходимое id пункта
        repository.deleteById(id);
        return "redirect:/";
    }
}
