package com.java.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.finalProject.model.Bill;
import com.java.finalProject.model.DetailBill;
import com.java.finalProject.repository.BillRepository;
import com.java.finalProject.repository.DetailBillRepository;
import com.java.finalProject.repository.TableRepository;

@Controller
@RequestMapping("/bill")
public class billController {
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private DetailBillRepository detailBillRepository;
	@GetMapping({"","/"})
	public String getAllBill(Model model) {
		List<Bill> bills = billRepository.findAll();
		model.addAttribute("bills", bills);
		return "home/bill";
	}
	 @GetMapping("/{id}")
	    @ResponseBody
	    public List<DetailBill> getBillDetailsById(@PathVariable("id") Long id) {
	        return detailBillRepository.findByBillsBillId(id);
	    }
}
