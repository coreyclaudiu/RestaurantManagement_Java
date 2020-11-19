package Composite;

import java.io.Serializable;
import java.util.ArrayList;

/** "Composite" */
public class CompositeProduct implements MenuItem, Serializable {
    //Collection of child graphics.
    private String name;
    private final ArrayList<MenuItem> childItems = new ArrayList<>();
    private double price;

    public ArrayList<MenuItem> getChildItems() {
        return childItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CompositeProduct(String name) {
        this.name=name;
    }

    //Adds the graphic to the composition.
    public void addItem(MenuItem item) {
        childItems.add(item);
    }

    //Prints the graphic.
    @Override
    public double computePrice() {
        price=0;
        for (MenuItem items : childItems) {
            price+=items.computePrice();
        }
        return price;
    }

    @Override
    public String getProduct() {

        String aux= "";
           for(MenuItem m: this.childItems){
               aux=aux.concat(m.getProduct() + " ");
           }
       return aux;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}