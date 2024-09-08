package com.Assignement.Abc_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.Assignement.Abc_backend.Dinein;
import com.Assignement.Abc_backend.Repository.DineinRepository;

@Service
public class DineinService {

    private final DineinRepository dineinrepository = null;

    
    

        public Dinein createDinein(Dinein dinein) {
            dinein.setStatus("Pending");
            return dineinrepository.save(dinein);
        }

    public List<Dinein> getAllthependings() {
        return dineinrepository.findByStatus("Pending");
    }

    public Dinein updateDineinStatus(String status, String id) {
        Dinein dinein = dineinrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        dinein.setStatus(status);
        return dineinrepository.save(dinein);
    }
}

