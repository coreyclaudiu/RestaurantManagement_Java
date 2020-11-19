import Administrator.AdminController;
import Administrator.AdminModel;
import Administrator.AdminView;
import Chef.ChefController;
import Chef.ChefModel;
import Chef.ChefView;
import Composite.MenuItem;
import Composite.Order;
import SelectMVC.SelectPersonController;
import SelectMVC.SelectPersonView;
import Waiter.WaiterController;
import Waiter.WaiterModel;
import Waiter.WaiterView;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Restaurant {

    private static Map<Order, List<MenuItem>> orderedProducts;
    private static List<MenuItem> stock;


    public static void main(String[] args) throws IOException {

//        Order o1=new Order(1, "12 mai 2020");
//        Order o2=new Order(2, "23 mai 2020");
//        Order o3=new Order(3, "01 iunie 2020");
//
//        BaseProduct egg= new BaseProduct("Egg", 0.5);
//        BaseProduct cheese= new BaseProduct("Cheese", 5.6);
//        BaseProduct tomatoes= new BaseProduct("Tomatoes", 2);
//        BaseProduct pasta= new BaseProduct("Pasta", 1.5);
//        BaseProduct juice= new BaseProduct("Juice", 3);
//
//        CompositeProduct omelet=new CompositeProduct("Omelet");
//        omelet.addItem(egg);
//        omelet.addItem(cheese);
//        omelet.addItem(tomatoes);
//        CompositeProduct carbonara=new CompositeProduct("Pasta Carbonara");
//        carbonara.addItem(egg);
//        carbonara.addItem(cheese);
//        carbonara.addItem(pasta);
//
//        List<MenuItem> l1=new ArrayList<>();
//        l1.add(omelet);
//        l1.add(juice);
//        List<MenuItem> l2=new ArrayList<>();
//        l2.add(juice);
//        List<MenuItem> l3=new ArrayList<>();
//        l3.add(carbonara);
//        l3.add(juice);
//        l3.add(cheese);
//
//        orderedProducts=new Hashtable<>();
//        orderedProducts.put(o1, l1);
//        orderedProducts.put(o2, l2);
//        orderedProducts.put(o3, l3);
//
//        try{
//            FileOutputStream fileOut=new FileOutputStream("extract.ser");
//            ObjectOutputStream out=new ObjectOutputStream(fileOut);
//            out.writeObject(orderedProducts);
//            out.close();
//            fileOut.close();
//            System.out.println("Done");
//
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(args[0]);

        stock=new ArrayList<>();
        orderedProducts=new Hashtable<>();

        try{
            FileInputStream fileIn=new FileInputStream(args[0]);
            ObjectInputStream in=new ObjectInputStream(fileIn);
            orderedProducts=(Map<Order, List<MenuItem>>)in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for(List<MenuItem> aux:orderedProducts.values()){
            stock.addAll(aux);
        }

        for(MenuItem aux: stock){
            System.out.println(aux.getName());
        }

        AdminView adminView=new AdminView();
        AdminModel adminModel=new AdminModel();

        WaiterView waiterView=new WaiterView();
        WaiterModel waiterModel=new WaiterModel();

        ChefView chefView=new ChefView();
        ChefModel chefModel=new ChefModel();

        SelectPersonView selectPersonView=new SelectPersonView();
        SelectPersonController selectPersonController=new SelectPersonController(selectPersonView, adminView, waiterView, chefView);

        WaiterController waiterController=new WaiterController(waiterView, waiterModel, selectPersonView, stock, orderedProducts, args[0]);
        AdminController adminController=new AdminController(adminView, adminModel, selectPersonView, stock);
        ChefController chefController=new ChefController(chefView, chefModel, selectPersonView);

        selectPersonView.setVisible(true);

    }
}
