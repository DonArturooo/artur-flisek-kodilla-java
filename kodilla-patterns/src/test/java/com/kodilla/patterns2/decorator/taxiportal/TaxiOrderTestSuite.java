package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class TaxiOrderTestSuite {

    private TaxiOrder taxiOrder;

    @BeforeEach
    void beforeEach() {
        taxiOrder = new BasicTaxiOrder();
    }

    @Test
    void testBasicTaxiOrderGetCost() {
        assertEquals(new BigDecimal(5), taxiOrder.getCost());
    }

    @Test
    void testBasicTaxiOrderGetDescription() {
        assertEquals("Drive a course", taxiOrder.getDescription());
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //When & Then
        assertEquals(new BigDecimal(40), taxiOrder.getCost());
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //When & Then
        assertEquals("Drive a course by Taxi Network", taxiOrder.getDescription());
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //Given
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        // When & Then
        assertEquals(new BigDecimal(37), taxiOrder.getCost());
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        //Given
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        /// When & Then
        assertEquals("Drive a course by MyTaxi Network + child seat", taxiOrder.getDescription());
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        //Given
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        // When & Then
        assertEquals(new BigDecimal(29), taxiOrder.getCost());
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        //Given
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        /// When & Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", taxiOrder.getDescription());
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        // When & Then
        assertEquals(new BigDecimal(57), taxiOrder.getCost());
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        /// When & Then
        assertEquals("Drive a course by Taxi Network express service variant VIP + child seat", taxiOrder.getDescription());
    }
}
