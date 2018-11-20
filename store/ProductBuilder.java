/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author Pawel
 */
public interface ProductBuilder {
    Product build();
    ProductBuilder setProdID(final String id);
    ProductBuilder setProdName(final String name);
    ProductBuilder setPrice(final double price);
    ProductBuilder setQuantity(final int quantity);
}