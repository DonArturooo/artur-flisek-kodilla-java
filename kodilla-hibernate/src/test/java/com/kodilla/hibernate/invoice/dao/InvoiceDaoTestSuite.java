package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave()
    {
        Product product1 = new Product("Test1");
        Product product2 = new Product("Test2");

        Item item1 = new Item(product1, new BigDecimal(10), 2);
        Item item2 = new Item(product2, new BigDecimal(15), 3);

        Invoice invoice = new Invoice("TEST_0");

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoiceDao.save(invoice);

        assertAll(
                () -> assertNotEquals(0, invoice.getId()),
                () -> assertEquals(1, invoiceDao.findAllBy().size()),
                () -> assertEquals(2, productDao.findAllBy().size()),
                () -> assertEquals(2, itemDao.findAllBy().size())
        );

        try {
            invoiceDao.deleteById(invoice.getId());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
