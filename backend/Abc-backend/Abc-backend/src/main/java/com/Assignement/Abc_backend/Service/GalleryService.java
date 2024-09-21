package com.Assignment.Abc_Restaurant.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Assignment.Abc_Restaurant.Fileuploadutil;
import com.Assignment.Abc_Restaurant.Model.Gallery;
import com.Assignment.Abc_Restaurant.Repository.GalleryRepository;

@Service
public class GalleryService {

    private final String uploadDir = "C:/Users/User/Documents/Sawdha/Assignment/Abc_Restaurant/src/main/resources/static/Galleryfolder";
    
    @Autowired
    private GalleryRepository galleryrepository;

     @Autowired
    private Fileuploadutil fileUploadUtil;
    

    public  Object allgallery() {
      
        return galleryrepository.findAll();
    }

    public Gallery addImages(String description, MultipartFile imageFile) throws IOException {
        
        String filename=imageFile.getOriginalFilename();
        fileUploadUtil.savefile("Galleryfolder", filename, imageFile);

        Gallery gallery = new Gallery();
        gallery.setDescription(description);
        gallery.setImageurl("/Galleryfolder/" + filename);
        


        return galleryrepository.save(gallery);

    }


}
