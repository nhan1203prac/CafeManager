package com.java.finalProject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.finalProject.model.Bill;
import com.java.finalProject.model.CartItemUpdateRequest;
import com.java.finalProject.model.DetailBill;
import com.java.finalProject.model.DrinksMenu;
import com.java.finalProject.model.billAndDetail;
import com.java.finalProject.model.carts;
import com.java.finalProject.model.category;
import com.java.finalProject.model.tables;
import com.java.finalProject.repository.BillRepository;
import com.java.finalProject.repository.CartRepository;
import com.java.finalProject.repository.DetailBillRepository;
import com.java.finalProject.repository.DrinksMenuRepository;
import com.java.finalProject.repository.TableRepository;
import com.java.finalProject.service.CafeService;

@Controller
@RequestMapping("/order")
public class categoryController {

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
   /* @GetMapping("/table")
  public String home(@RequestParam("tableId") Long tableId,Model model) {
       List<category> allCategories = cafeService.getAllCategory();
       model.addAttribute("categorys", allCategories);
       
       tables table = tableRepository.findById(tableId).get();
       String tableName = table.getTableName();
       model.addAttribute("tableName", tableName);
       if (!allCategories.isEmpty()) {
           Long firstCategoryId = allCategories.get(0).getCategoryId();
           model.addAttribute("drinksMenu", cafeService.getMenuByCategoryId(firstCategoryId));
           model.addAttribute("activeCategoryId", firstCategoryId);
       }

       return "home/order";
   }*/

   @GetMapping("/table/category")
   public String getDrinksByCategory(@RequestParam("tableId") Long tableId,@RequestParam("category") Long categoryId, Model model) {
	   List<category> allCategories = cafeService.getAllCategory();
       model.addAttribute("categorys", allCategories);
       
       tables table = tableRepository.findById(tableId).get();
       String tableName = table.getTableName();
       model.addAttribute("tableName", tableName);
       if (!allCategories.isEmpty()) {
           Long firstCategoryId = allCategories.get(0).getCategoryId();
           model.addAttribute("tableId", tableId);
           
       }
       model.addAttribute("drinksMenu", cafeService.getMenuByCategoryId(categoryId));
       model.addAttribute("activeCategoryId", categoryId);
       return "home/order";
   }

   @PostMapping("/add-to-cart")
   @ResponseBody
   public carts addToCart(@RequestBody carts orderItem) {
      
       List<carts> carts = cartRepository.findByTableName(orderItem.getTableName());
       
       for (carts cart : carts) {
         
           if (cart.getDrinkName().equals(orderItem.getDrinkName())) {
               cart.setQuantity(cart.getQuantity() + orderItem.getQuantity());
               return cartRepository.save(cart);
           }
       }
       
      
       return cartRepository.save(orderItem);
   }
   @GetMapping("/cart")
   public String getCartByTable(@RequestParam("tableName") String tableName, Model model) {
	   List<String> tableNameList = cafeService.getAllTableInCart();
	   model.addAttribute("tableNameList", tableNameList);
	   
	   model.addAttribute("activeTableName", tableName);
	   List<carts> cartList = cafeService.getCartByTableId(tableName);
	   Double totalPrices = cartList.stream().mapToDouble(item -> item.getQuantity() * item.getDrinkPrice()).sum();
	   model.addAttribute("cartList",cartList);
	   model.addAttribute("totalPrice", totalPrices);
	   return "home/cart";
   }
   @PutMapping("/cart/update-cart-item")
   public ResponseEntity<?> updateCart(@RequestBody CartItemUpdateRequest orderItem) {
	    try {
	        carts item = cartRepository.findByDrinkNameAndTableName(orderItem.getDrinkName(), orderItem.getTableName());
	        if (item != null) {
	            item.setQuantity(orderItem.getQuantity());
	            cartRepository.save(item);
	            return ResponseEntity.ok(item);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart item not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating cart item");
	    }
	}
   
   @DeleteMapping("/cart/remove-cart-item")
   public ResponseEntity<?> removeCartItem(@RequestParam("drinkName") String drinkName, @RequestParam("tableName") String tableName) {
       try {
           carts cartItem = cartRepository.findByDrinkNameAndTableName(drinkName, tableName);
           if (cartItem != null) {
               cartRepository.delete(cartItem);
               return ResponseEntity.ok().body("Cart item removed successfully");
           } else {
               return ResponseEntity.notFound().build(); 
           }
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing cart item");
       }
   }
   @PostMapping("/createBill")
   @ResponseBody
   public carts createBill(@RequestBody billAndDetail billItem) {
	   tables table = tableRepository.findByTableName(billItem.getTableName());
	   Bill bill = new Bill();
	   bill.setTable(table);
	   bill.setTotalPrice(billItem.getTotalPrice());
	   Date currentDate = new Date();
	   bill.setDate(currentDate);
	   
	   Bill savedBill = billRepository.save(bill);
	   
	   List<DetailBill> detailBills = new ArrayList<DetailBill>();
	   List<carts> carts = cartRepository.findByTableName(billItem.getTableName());
	   
	   for (carts carts2 : carts) {
		
		DetailBill detailBill = new DetailBill();
		detailBill.setBills(savedBill);
		
		DrinksMenu drink = drinkMenuRepository.findByDrinkName(carts2.getDrinkName());
		detailBill.setDrinkMenu(drink);
		detailBill.setPrice(drink.getPrice());
		detailBill.setQuantity(carts2.getQuantity());
		
		detailBills.add(detailBill);
		detailBillRepository.save(detailBill);
	}
	   savedBill.setDetailBill(detailBills);
	   billRepository.save(savedBill);
	   cartRepository.deleteByTableName(billItem.getTableName());
	   
	   return null;
   }
   
   
}
