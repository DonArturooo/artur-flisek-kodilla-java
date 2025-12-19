package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item, Integer> {
    List<Item> findAllBy();
}
