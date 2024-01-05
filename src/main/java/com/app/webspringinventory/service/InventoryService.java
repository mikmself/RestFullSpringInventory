package com.app.webspringinventory.service;

import com.app.webspringinventory.entity.Inventory;
import com.app.webspringinventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;
    public void save(Inventory inventory) {
        repository.save(inventory);
    }
    public List<Inventory> get() {
        return repository.findAll();
    }
    public Inventory getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
