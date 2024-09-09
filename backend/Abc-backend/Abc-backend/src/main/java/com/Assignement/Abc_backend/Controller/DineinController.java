package com.Assignment.Abc_Restaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.Abc_Restaurant.Dinein;
import com.Assignment.Abc_Restaurant.Service.DineinService;

@RestController
@RequestMapping("/Dinein")
public class DineinController {
    @Autowired
    DineinService dineinservice;


    @PostMapping("/Add")
    public ResponseEntity<Dinein> createDinein(@RequestBody Dinein dinein){

    dinein.setStatus("Pending");
   
    Dinein savedDinein=dineinservice.createDinein(dinein);

      return new ResponseEntity<>(savedDinein, HttpStatus.CREATED);

    }
    @GetMapping("/pending")
    public ResponseEntity<List<Dinein>> getAllPendingDinein() {
        List<Dinein> pendingDineins = dineinservice.getAllthependings();
        return new ResponseEntity<>(pendingDineins, HttpStatus.OK);
    }
    
    

    
    
}
