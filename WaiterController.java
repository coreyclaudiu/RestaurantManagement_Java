package Waiter;

import Composite.MenuItem;
import Composite.Order;
import SelectMVC.SelectPersonView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WaiterController {
    private WaiterView theView;
    private WaiterModel theModel;
    private SelectPersonView selectPersonView;
    private Map<Order, List<MenuItem>> orderListMap;
    private List<MenuItem> stock;
    private String file;

    public WaiterController(WaiterView view, WaiterModel model, SelectPersonView selectView, List<MenuItem> stock, Map<Order, List<MenuItem>> orderedProducts, String file){
        this.theModel=model;
        this.theView=view;
        this.stock=stock;
        this.selectPersonView=selectView;
        this.orderListMap=orderedProducts;
        this.file=file;


        //LISTENERS +++++++++++++++++++++++++++++++++++++++++++++
        this.theView.newOrderAction(new newOrderListener());
        this.theView.compute(new computePriceListener());
        this.theView.generateB(new generateBillListener());
        this.theView.getback(new getBackListener());
        this.theView.setShowOrders(new setShowOrders());

    }


    class getBackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                selectPersonView.setVisible(true);
                theView.setVisible(false);
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class newOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                List<MenuItem> orderedItems=new ArrayList<>();
                String[] items=theView.getItems().split("[,]");
                String id=theView.getID();
                String date=theView.getDate();

                for(int i=0; i<items.length; i++){
                    items[i]=items[i].replace(" ", "");
                }

                orderedItems=theModel.getItems(orderedItems, stock, items);
                Order newOrder=new Order(Integer.parseInt(id), date);
                orderListMap.put(newOrder, orderedItems);

                Object[][] prods;

                for(List<MenuItem> aux: orderListMap.values()){
                    for(MenuItem aux2: aux){
                        System.out.println(aux2.getProduct());
                    }
                }

                System.out.println("New Order button pressed");
                try{
                    FileOutputStream fileout=new FileOutputStream(file);
                    ObjectOutputStream in=new ObjectOutputStream(fileout);
                    in.writeObject(orderListMap);
                    in.close();
                    fileout.close();
                    System.out.println("Done");

                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            catch (Exception ex){
                ex.getMessage();
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class computePriceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String id=theView.getID();
                String date=theView.getDate();

                Order newOrder=new Order(Integer.parseInt(id), date);

                List<MenuItem> foundItem=orderListMap.get(newOrder);

                double computePrice=0;
                for(MenuItem aux: foundItem){
                    computePrice+=aux.computePrice();
                }

                theView.setPrice(String.valueOf(computePrice));
                System.out.println("compute pressed");

            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class setShowOrders implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String[] columns = {"Id Order","Date","Products", "Price"};
                String[][] data=new String[100][5];

                data=theModel.getData(orderListMap);

                JFrame frame=new JFrame();
                JTable jt=new JTable(data,columns);
                jt.setBounds(30,40,400,200);
                JScrollPane sp=new JScrollPane(jt);
                frame.add(sp);
                frame.setSize(400,200);
                frame.setVisible(true);

            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class generateBillListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String id=theView.getID();
                String date=theView.getDate();

                Order newOrder=new Order(Integer.parseInt(id), date);
                List<MenuItem> foundItem=orderListMap.get(newOrder);

                PrintWriter out=new PrintWriter("Generated Bill_id" + id);
                out.println("SC zTIO SRL");
                out.println("ID: " + id);
                out.println("Date: " + date);
                out.println();
                out.println();
                out.println("Ordered items summary");
                for(MenuItem aux: foundItem){
                    if(aux.getClass().getSimpleName().contentEquals("CompositeProduct")){
                        out.println(aux.getName() + "       " + aux.computePrice());
                        out.println("   having: " + aux.getProduct());

                    }
                    else{
                        out.println(aux.getName() + "       " + aux.computePrice());
                    }
                }
                out.close();
                System.out.println("generate bill pressed");
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

}

