package aut.utcluj.isp.UI;

import aut.utcluj.isp.UI.MVC.Controller;
import aut.utcluj.isp.UI.MVC.Model;
import aut.utcluj.isp.UI.MVC.View;

public class Client {

    public static void main(String[] args) {
        View view = new View("Equipment Controller");
        Model model = new Model();
        Controller controller = new Controller(model,view);
        controller.initController();
    }
}
