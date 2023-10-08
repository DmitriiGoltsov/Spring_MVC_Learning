package com.goltsov.springcourse.services;

import com.goltsov.springcourse.models.Item;
import com.goltsov.springcourse.models.Person;
import com.goltsov.springcourse.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findItemsByOwner(Person owner) {
        return itemsRepository.findItemsByOwner(owner);
    }

    public List<Item> findItemsByItemName(String itemName) {
        return itemsRepository.findItemsByItemName(itemName);
    }
}
