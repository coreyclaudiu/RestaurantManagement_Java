package SelectMVC;

import Administrator.AdminView;
import Chef.ChefView;
import Waiter.WaiterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPersonController {
    private SelectPersonView theView;
    private AdminView adminView;
    private ChefView chefView;
    private WaiterView waiterView;


    public SelectPersonController(SelectPersonView view, AdminView adminView, WaiterView waiterView, ChefView chefView){
        this.theView=view;
        this.adminView=adminView;
        this.chefView=chefView;
        this.waiterView=waiterView;

        //LISTENERS +++++++++++++++++++++++++++++++++++++++++++++
        this.theView.selectAdmin(new SelectAdminListener());
        this.theView.selectWaiter(new SelectWaiterListener());
        this.theView.selectChef(new SelectChefListener());

    }

    class SelectAdminListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                adminView.setVisible(true);
                theView.setVisible(false);

            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class SelectWaiterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                waiterView.setVisible(true);
                theView.setVisible(false);
            }
            catch (Exception ex) {
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

    class SelectChefListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                chefView.setVisible(true);
                theView.setVisible(false);
            }
            catch (Exception ex){
                System.out.println("Something went wrong! Please try again later...");
            }
        }
    }

}

