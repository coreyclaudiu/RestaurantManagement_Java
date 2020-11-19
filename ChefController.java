package Chef;

import Composite.MenuItem;
import Composite.Order;
import SelectMVC.SelectPersonView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ChefController implements Subject{

    private ChefView theView;
    private ChefModel theModel;
    private SelectPersonView selectPersonView;
    private Map<Order, List<MenuItem>> orderListMap;
    private Observer observer;


    public ChefController(ChefView chefView, ChefModel chefModel, SelectPersonView selectPersonView) {
        this.theModel=chefModel;
        this.theView=chefView;
        this.selectPersonView=selectPersonView;
        orderListMap=new Hashtable<>();

        this.theView.getBack(new getBackListener());
    }

    @Override
    public void notifySubject(List<MenuItem> menuItems) {

    }


    class getBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                selectPersonView.setVisible(true);
                theView.setVisible(false);

            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}
