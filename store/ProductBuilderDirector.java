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
public class ProductBuilderDirector {
    private ProductBuilder builder;
    
    public ProductBuilderDirector(final ProductBuilder builder) {
        this.builder = builder;
    }
    
    public Product construct(String id, String name,double price,int quantity) {
        return builder.setProdID(id).setProdName(name).setPrice(price).setQuantity(quantity).build();
    }
}