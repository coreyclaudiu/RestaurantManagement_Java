package Administrator;

import Composite.BaseProduct;
import Composite.MenuItem;
import SelectMVC.SelectPersonView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminController {
    private AdminView theView;
    private AdminModel theModel;
    private SelectPersonView selectPersonView;
    private List<MenuItem> stock;


    public AdminController(AdminView view, AdminModel model, SelectPersonView selectPersonView,List<MenuItem> map){
        this.theModel=model;
        this.theView=view;
        this.selectPersonView=selectPersonView;
        this.stock=map;

        //LISTENERS +++++++++++++++++++++++++++++++++++++++++++++
        this.theView.addItemAdmin1(new AddItemAdminListener1());
        this.theView.removeItemAdmin1(new RemoveItemListener1());
        this.theView.editItemAdmin1(new EditItemListener1());
        this.theView.addItemAdmin2(new AddItemAdminListener2());
        this.theView.removeItemAdmin2(new RemoveItemListener2());
        this.theView.editItemAdmin2(new EditItemListener2());
        this.theView.getBack(new getBackListener());

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

    class AddItemAdminListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String[] price=theView.getPrice1().split("[,]");
                String[] product=theView.getProd1().split("[,]");
                for(int i=0; i<product.length; i++){
                    product[i]=product[i].replace(" ", "");
                    price[i]=price[i].replace(" ", "");
                }

                for(int i=0; i<price.length; i++){
                    BaseProduct base=new BaseProduct(product[i], Double.parseDouble(price[i]));
                    stock.add(base);
                }

                for(MenuItem m: stock){
                    System.out.println(m.getProduct());
                }
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class EditItemListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String[] product = theView.getProd1().split("[,]");
                String[] price=theView.getPrice1().split("[,]");
                for(int i=0; i<product.length; i++){
                    product[i]=product[i].replace(" ", "");
                    price[i]=price[i].replace(" ", "");
                }

                stock=theModel.editBase(stock, product, price);

                for(MenuItem m: stock){
                    System.out.println(m.getProduct() + " " + m.computePrice());
                }

                System.out.println("Edit item pressed");
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class RemoveItemListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String[] product=theView.getProd1().split("[,]");
                for(int i=0; i<product.length; i++){
                    product[i]=product[i].replace(" ", "");
                 }

                for(int i=0; i<product.length; i++){
                    for(MenuItem aux: stock){
                        if(aux.getProduct().contentEquals(product[i])){
                            stock.remove(aux);
                        }
                    }
                }

                for(MenuItem m: stock){
                    System.out.println(m.getProduct() + " " + m.computePrice());
                }

                System.out.println("Remove item pressed");
            }
            catch (Exception ex){
                System.out.println("Empty Menu!");
                //System.out.println(ex.getMessage());
            }
        }
    }

    class AddItemAdminListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String[] product=theView.getProd2().split("[,]");
                String name=theView.getPrice2();
                for(int i=0; i<product.length; i++){
                    product[i]=product[i].replace(" ", "");
                }
                stock=theModel.extractData(product, stock, name);

                for(MenuItem m: stock){
                    System.out.println(m.getProduct() + " " + m.computePrice());
                }
                System.out.println("Add button pressed");
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class EditItemListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String name=theView.getPrice2();
                String[] product=theView.getProd2().split("[,]");
                for(int i=0; i<product.length; i++){
                    product[i]=product[i].replace(" ", "");
                 }
                stock=theModel.editComposite(stock, name, product);

                for(MenuItem m: stock){
                    System.out.println(m.getProduct() + " " + m.computePrice());
                }

                System.out.println("Edit item pressed");
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class RemoveItemListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String name=theView.getPrice2();

                for(MenuItem aux: stock){
                    if(aux.getName().contentEquals(name)){
                        stock.remove(aux);
                    }
                }

                for(MenuItem m: stock){
                    System.out.println(m.getProduct() + " " + m.computePrice());
                }
                
                System.out.println("Remove item pressed");
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }



}

