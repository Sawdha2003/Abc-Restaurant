package com.Assignement.Abc_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignement.Abc_backend.Dinein;
import com.Assignement.Abc_backend.Repository.DineinRepository;


@Service
public class DineinService {


    private DineinRepository dineinrepository;

    
    @Autowired
        public DineinService(DineinRepository dineinRepository) {
            this.dineinrepository = dineinRepository;
        }


        public Dinein createDinein(Dinein dinein) {
            return dineinrepository.save(dinein);
        }

        public List<Dinein> getAllthependings(){

            return dineinrepository.findByStatus("Pending");


        }
    }


