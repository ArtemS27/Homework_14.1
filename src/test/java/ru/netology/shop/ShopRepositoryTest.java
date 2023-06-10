package ru.netology.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();
    Product product1 = new Product(12, "Blanket", 300);
    Product product2 = new Product(45, "Coat", 2800);
    Product product3 = new Product(29, "Pants", 1100);
    Product product4 = new Product(72, "Hat", 500);
    Product product5 = new Product(89, "Socks", 100);
    Product product6 = new Product(45, "Shoes", 1500);


    @Test
    void deleteElementFromRepository(){
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        repository.remove(45);
        Product[] expected = {product1, product3, product4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteNonExistIdFromRepository(){
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(79));
    }

    @Test
    void addNewElementToTheRepository(){
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addElementWithIdAlreadyExist(){
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Assertions.assertThrows(AlreadyExistException.class, () -> repository.add(product6));
    }
}
