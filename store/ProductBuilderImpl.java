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
public class ProductBuilderImpl implements ProductBuilder{
    private Product p;

    public ProductBuilderImpl() {
        p = new Product();
    }
    
    @Override
    public Product build(){
        return p;
    }
    
    @Override
    public ProductBuilder setProdID(final String id){
        p.setProdID(id);
        return this;
    }
    
    @Override
    public ProductBuilder setProdName(final String name){
        p.setProdName(name);
        return this;
    }
    
    @Override
    public ProductBuilder setPrice(final double price){
        p.setPrice(price);
        return this;
    }
    
    @Override
    public ProductBuilder setQuantity(final int quantity){
        p.setQuantity(quantity);
        return this;
    }
}
