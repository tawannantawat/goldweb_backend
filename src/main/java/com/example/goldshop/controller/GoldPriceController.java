package com.example.goldshop.controller;


import com.example.goldshop.service.GoldPriceService;
import com.example.goldshop.service.GoldPriceService.GoldPrice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gold-price")
public class GoldPriceController {

    private final GoldPriceService goldPriceService;

    public GoldPriceController(GoldPriceService goldPriceService) {
        this.goldPriceService = goldPriceService;
    }

    @GetMapping
    public GoldPrice getGoldPrice() throws Exception {
        return goldPriceService.getGoldPrice();
    }
}