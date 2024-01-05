package com.app.webspringinventory.service;

import com.app.webspringinventory.entity.Custodian;
import com.app.webspringinventory.repository.CustodianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustodianService {
    @Autowired
    private CustodianRepository repository;
    public void save(Custodian custodian) {
        repository.save(custodian);
    }
    public List<Custodian> get() {
        return repository.findAll();
    }
    public Custodian getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
