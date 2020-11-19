package Chef;

import Composite.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Chef implements Observer {

    private List<MenuItem> menuItems;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public String getItems(){
        String string="";
        for(MenuItem items: menuItems){
            string=string.concat(items.getName() + " ");
        }
        return string;
    }

    @Override
    public void update(List<MenuItem> obj) {
        this.menuItems=obj;
    }
}
