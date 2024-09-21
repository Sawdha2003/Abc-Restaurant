
package com.Assignment.Abc_Restaurant.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Assignment.Abc_Restaurant.Model.Gallery;

@Repository
public interface GalleryRepository extends MongoRepository<Gallery, ObjectId>{

    
    
}