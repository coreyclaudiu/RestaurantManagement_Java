package Administrator;

import Composite.BaseProduct;
import Composite.CompositeProduct;
import Composite.MenuItem;

import java.util.List;

public class AdminModel {

    List<MenuItem> extractData(String[] product, List<MenuItem> stock, String name){
        CompositeProduct compositeProduct=new CompositeProduct(name);

        for (String s : product) {
            double price_aux=-1.0;
            for (MenuItem aux : stock) {
                //System.out.println("Proba: " + aux.getProduct());
                if (s.contentEquals(aux.getProduct())) {
                    price_aux = aux.computePrice();
                    break;
                }
            }
            if (price_aux == -1.0) {
                System.out.println("Something went wrong! Item couldn't be found");
                compositeProduct=null;
                break;
            }
            BaseProduct baseProduct = new BaseProduct(s, price_aux);
            compositeProduct.addItem(baseProduct);
        }
        if(compositeProduct!=null){
            stock.add(compositeProduct);
        }

        return stock;
    }

    List<MenuItem> editComposite(List<MenuItem> stock, String name, String[] product){
        try{
            for(MenuItem aux: stock){
                if(aux.getName().contentEquals(name)){
                    stock.remove(aux);
                    CompositeProduct compositeProduct=new CompositeProduct(name);
                    for(int i=0; i<product.length; i++){
                        if(aux.getName().contentEquals(product[i])){
                            BaseProduct baseProduct=new BaseProduct(product[i], aux.computePrice());
                            compositeProduct.addItem(baseProduct);
                        }
                    }
                    stock.add(compositeProduct);
                    break;
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return stock;
    }

    List<MenuItem> editBase(List<MenuItem> stock, String[] product, String[] price){

        try{
            for(int i=0; i<product.length; i++){
                for(MenuItem aux: stock){
                    if(aux.getProduct().contentEquals(product[i])){
                        aux.setPrice(Double.parseDouble(price[i]));
                        break;
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return stock;
    }


}
