package com.app.webspringinventory.service;

import com.app.webspringinventory.entity.Item;
import com.app.webspringinventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    public void save(Item item) {
        repository.save(item);
    }
    public List<Item> get() {
        return repository.findAll();
    }
    public Item getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
