package com.example.controller;



import com.example.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @GetMapping("/purchase")
    public String purchasebook(){
        sellService.createSellRequest();
        return "satis basliyor";
    }
}

