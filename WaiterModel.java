package Waiter;

import Composite.MenuItem;
import Composite.Order;

import java.util.List;
import java.util.Map;

public class WaiterModel {

    public List<MenuItem> getItems(List<MenuItem> orderedItems, List<MenuItem> stock, String[] items){
        for (String item : items) {
            for (MenuItem aux : stock) {
                if (aux.getName().contentEquals(item)) {
                    orderedItems.add(aux);
                    break;
                }
            }
        }
        return orderedItems;
    }

    public String[][] getData(Map<Order, List<MenuItem>> orderListMap){
        String[][] data=new String[100][5];
        int counter=0;
        for(Order aux: orderListMap.keySet()){
            data[counter][0]=String.valueOf(aux.getOrderID());
            data[counter][1]=aux.getDate();
            counter++;
        }

        counter=0;
        for(List<MenuItem> aux: orderListMap.values()){
            String prods= "";
            double price=0;
            for(MenuItem items: aux){
                price+=items.computePrice();
                prods=prods.concat(items.getName() + ", ");
            }
            data[counter][2]=prods;
            data[counter][3]=String.valueOf(price);
            counter++;
        }
        return data;
    }

}
