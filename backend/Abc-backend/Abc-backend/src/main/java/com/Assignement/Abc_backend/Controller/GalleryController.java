package com.Assignment.Abc_Restaurant.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Assignment.Abc_Restaurant.Model.Gallery;
import com.Assignment.Abc_Restaurant.Service.GalleryService;

@Controller

public class GalleryController {
    @Autowired
    private GalleryService galleryService;



@GetMapping("/view-gallery")
public ResponseEntity<List<Gallery>> getallgallery(){


    List<Gallery> galleryList = (List<Gallery>) galleryService.allgallery();

    return new ResponseEntity<>(galleryList,HttpStatus.OK);
    
} 
  @PostMapping("/add-gallery")
    public ResponseEntity<Gallery> addGallery(
        @RequestParam("description") String description, 
        @RequestParam("imageurl") MultipartFile imageFile) {
        
            String uploadDir="Galleryfolder";
            
        try {
           
            Gallery newGalleryImage = galleryService.addImages(description, imageFile);
            return ResponseEntity.ok(newGalleryImage);
            
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/view-add")
    public String getaddgallerypage (Model model){

         model.addAttribute("gallery", new Gallery());


        return "AddGallery";

    }

    @GetMapping("/view-images")
    public String getgallerypage (Model model){

        model.addAttribute("gallery", new Gallery());


        return "Gallery";
    }

    @GetMapping("/image-customer")
    public String getcustomerimage (Model model){

        model.addAttribute("gallery", new Gallery());

        return "CustomerGallery";
    } 
}
