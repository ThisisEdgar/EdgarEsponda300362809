package com.example.edgaresponda300362809;

import com.example.edgaresponda300362809.Component.category;
import com.example.edgaresponda300362809.Component.items;
import com.example.edgaresponda300362809.repository.categoryRepository;
import com.example.edgaresponda300362809.repository.itemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdgarEsponda300362809Application implements CommandLineRunner {

    @Autowired
    private categoryRepository categoryRepository2;

    @Autowired
    private itemsRepository itemsRepository2;

    public static void main(String[] args) {
        SpringApplication.run(EdgarEsponda300362809Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert initial data into Category table
        categoryRepository2.save(new category("101", "School Supplies"));
        categoryRepository2.save(new category("102", "Drinks"));
        categoryRepository2.save(new category("103", "Dog Items"));

        // Insert initial data into Items table
        itemsRepository2.save(new items("102", "J102A", "Coke", 5));
        itemsRepository2.save(new items("101", "J102B", "Vines Paper pad", 4));
        itemsRepository2.save(new items("102", "J102C", "Pepsi", 4));
        itemsRepository2.save(new items("103", "J103C", "Punna Dog Food", 22.5f));
        itemsRepository2.save(new items("101", "J101C", "Xyz Eraser", 1.5f));
        itemsRepository2.save(new items("103", "J103D", "Dog Chew Toy", 13.5f));
    }
}
