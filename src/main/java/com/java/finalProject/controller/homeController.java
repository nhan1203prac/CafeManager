package com.java.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.finalProject.model.areas;
import com.java.finalProject.model.tables;
import com.java.finalProject.repository.AreaRepository;
import com.java.finalProject.repository.TableRepository;
import com.java.finalProject.service.CafeService;

@Controller
@RequestMapping("/home")
public class homeController {

    @Autowired
    private CafeService cafeService;

    @GetMapping({"","/"})
    public String home(Model model) {
        List<areas> allAreas = cafeService.getAllAreas();
        model.addAttribute("areas", allAreas);

        if (!allAreas.isEmpty()) {
            Long firstAreaId = allAreas.get(0).getAreaId();
            model.addAttribute("tables", cafeService.getTablesByAreaId(firstAreaId));
            model.addAttribute("activeAreaId", firstAreaId);
        }

        return "home/trangchu";
    }

    @GetMapping("/area")
    public String getTablesByArea(@RequestParam("id") Long areaId, Model model) {
    	 List<areas> allAreas = cafeService.getAllAreas();
         model.addAttribute("areas", allAreas);
        model.addAttribute("tables", cafeService.getTablesByAreaId(areaId));
        model.addAttribute("activeAreaId", areaId);
        return "home/trangchu";
    }
}
