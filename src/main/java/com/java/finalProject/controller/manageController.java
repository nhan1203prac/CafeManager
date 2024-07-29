package com.java.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.finalProject.model.DrinksMenu;
import com.java.finalProject.model.areas;
import com.java.finalProject.model.tables;
import com.java.finalProject.repository.AreaRepository;
import com.java.finalProject.repository.BillRepository;
import com.java.finalProject.repository.CartRepository;
import com.java.finalProject.repository.DetailBillRepository;
import com.java.finalProject.repository.DrinksMenuRepository;
import com.java.finalProject.repository.TableRepository;
import com.java.finalProject.service.CafeService;

@Controller
@RequestMapping("/manage-and-update")
public class manageController {
   @Autowired
   private CafeService cafeService;
   @Autowired
   private TableRepository tableRepository;
   @Autowired
   private CartRepository cartRepository;
   @Autowired
   private BillRepository billRepository;
   @Autowired
   private DrinksMenuRepository drinkMenuRepository;
   @Autowired
   private DetailBillRepository detailBillRepository;
   @Autowired
   private AreaRepository areaRepository;
   
   @GetMapping("/areas")
   public String getAreas(Model model) {
       List<areas> listItem = areaRepository.findAll();
       model.addAttribute("listItem", listItem);
       model.addAttribute("selectedButton", "Area");
       return "home/manageAndUpdate"; 
   }

   @GetMapping("/tables")
   public String getTables(Model model) {
       List<tables> listItem = tableRepository.findAll();
       model.addAttribute("listItem", listItem);
       model.addAttribute("selectedButton", "Table");
       return "home/manageAndUpdate";
   }

   @GetMapping("/menu")
   public String getMenu(Model model) {
       List<DrinksMenu> listItem = drinkMenuRepository.findAll();
       model.addAttribute("listItem", listItem);
       model.addAttribute("selectedButton", "Menu");
       return "home/manageAndUpdate"; 
   }

}
