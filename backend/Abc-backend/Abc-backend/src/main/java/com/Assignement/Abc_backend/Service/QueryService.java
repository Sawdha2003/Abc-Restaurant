package com.Assignment.Abc_Restaurant.Service;

import org.springframework.stereotype.Service;

import com.Assignment.Abc_Restaurant.Model.Contact;
import com.Assignment.Abc_Restaurant.Repository.QueryRepository;

@Service
public class QueryService {

    private final QueryRepository queryRepository;

    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public Contact saveQuery(Contact contact) {
        return queryRepository.save(contact);
    }
}
