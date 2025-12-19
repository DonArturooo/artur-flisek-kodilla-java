package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    List<Product> findAllBy();
}
