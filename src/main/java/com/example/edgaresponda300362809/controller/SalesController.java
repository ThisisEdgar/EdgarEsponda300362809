
package com.example.edgaresponda300362809.controller;

import com.example.edgaresponda300362809.Component.category;
import com.example.edgaresponda300362809.Component.items;
import com.example.edgaresponda300362809.Component.sales;
import com.example.edgaresponda300362809.repository.categoryRepository;
import com.example.edgaresponda300362809.repository.itemsRepository;
import com.example.edgaresponda300362809.repository.salesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SalesController {
    //https://github.com/ThisisEdgar/EdgarEsponda300362809.git
    @Autowired
    private itemsRepository itemsRepo;

    @Autowired
    private salesRepository salesRepo;
    @Autowired
    private categoryRepository categoryRepo;
    //Method to display the main page, we need to use the url http://localhost:8080/salesForm to access the main page
    @GetMapping("/salesForm")
    public String salesForm(Model model) {
        List<category> categoryList = categoryRepo.findAll();
        List<items> itemList = itemsRepo.findAll();
        List<sales> salesList = salesRepo.findAll();
        model.addAttribute("salesForm", new sales());
        model.addAttribute("items", itemList);
        // Creat
        List<Object[]> categorySalesData = new ArrayList<>();
        for (category cat : categoryList) {
            long totalSales = salesList.stream()
                    .filter(sale -> sale.getIcode().equals(cat.getCatcode()))
                    .count();
            categorySalesData.add(new Object[]{cat.getCatcode(), cat.getCatdesc(), totalSales});
        }

        // Create a List of objects to hold receipt details data
        List<Object[]> receiptDetailsData = new ArrayList<>();
        for (sales sale : salesList) {
            receiptDetailsData.add(new Object[]{
                    sale.getRecno(), sale.getIcode(), sale.getQty(), sale.getDot(),sale.getId()
            });
        }

        model.addAttribute("categorySales", categorySalesData);
        model.addAttribute("receiptDetails", receiptDetailsData);

        return "salesForm";
    }

    @GetMapping("/deleteReceipt/{id}")
    public String deleteReceipt(@PathVariable Long id) {
        salesRepo.deleteById(id);
        return "redirect:/salesForm";
    }

    // Save the sale
    @PostMapping("/submit")
    public String submitSalesForm(sales sales) {
        // Save or update the sales data to the database using the salesRepo
        salesRepo.save(sales);
        return "redirect:/salesForm";
    }
    @GetMapping("/editReceipt/{id}")
    public String editReceipt(@PathVariable Long id, Model model) {
        Optional<sales> receipt = salesRepo.findById(id);
        if (receipt.isPresent()) {
            model.addAttribute("editedSale", receipt.get());
            List<items> itemList = itemsRepo.findAll();
            model.addAttribute("items", itemList);
            model.addAttribute("salesId", receipt.get().getId()); // Pass the sales ID
            return "editSale"; // Return the editSale.html template
        } else {
            return "redirect:/salesForm";
        }
    }

    @PostMapping("/updateSale")
    public String updateSale(sales editedSale) {
        // Save or update the edited sales data to the database using the salesRepo
        salesRepo.save(editedSale);
        return "redirect:/salesForm";
    }
}