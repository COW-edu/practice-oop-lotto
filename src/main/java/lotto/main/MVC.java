package lotto.main;
import lotto.controller.Controller;
import lotto.model.Model;
import lotto.view.View;

public class MVC {
    View view;
    Model model;
    Controller controller;
    MVC(){
        view = new View();
        model = new Model();
        controller = new Controller(view, model);
    }
    public void start(){
        controller.start();
    }
    
    public void initalize(){

    }
}
