package com.goltsov.springcourse.repositories;

import com.goltsov.springcourse.models.Item;
import com.goltsov.springcourse.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findItemsByOwner(Person owner);

    List<Item> findItemsByItemName(String itemName);
}
