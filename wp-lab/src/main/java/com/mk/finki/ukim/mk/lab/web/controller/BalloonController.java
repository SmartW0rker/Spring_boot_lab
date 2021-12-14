package com.mk.finki.ukim.mk.lab.web.controller;

import com.mk.finki.ukim.mk.lab.exceptions.ManufacturerNotFound;
import com.mk.finki.ukim.mk.lab.model.Balloon;
import com.mk.finki.ukim.mk.lab.model.Manufacturer;
import com.mk.finki.ukim.mk.lab.service.impl.BaloonServiceImpl;
import com.mk.finki.ukim.mk.lab.service.impl.ManufacturerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BaloonServiceImpl baloonService;
    private final ManufacturerServiceImpl manufacturerService;

    public BalloonController(BaloonServiceImpl baloonService, ManufacturerServiceImpl manufacturerService) {
        this.baloonService = baloonService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){

        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        else
            model.addAttribute("hasError", false);

        List<Balloon> balloons = new ArrayList<>(baloonService.listAll());
        model.addAttribute("balloons",balloons);
        return "listBalloons";
    }
   @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.baloonService.deleteById(id);
        return "redirect:/balloons";
    }


    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model) {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }

    @GetMapping("edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id,Model model){
        Balloon balloon=baloonService.listAll().stream().filter(b-> b.getId().equals(id)).findFirst().orElse(null);
        if(balloon==null)
            return "redirect:/balloons?error=balloonNotFound";
        model.addAttribute("balloon",balloon);
        model.addAttribute("manufacturers",manufacturerService.findAll());
        return "add-balloon";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam(required = false) Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer
    ){
        if (id!=null){


            baloonService.edit(id,name,description,manufacturer);
            return "redirect:/balloons";
        }
        Manufacturer manufacturerObject=manufacturerService.
                findAll().stream().filter(m->m.getId()
                .equals(manufacturer)).findFirst()
                .orElseThrow(()->new ManufacturerNotFound(manufacturer));
        baloonService.save(new Balloon(name,description,manufacturerObject));
        return "redirect:/balloons";
    }
}
