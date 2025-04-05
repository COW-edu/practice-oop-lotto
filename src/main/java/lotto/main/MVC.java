package lotto.main;
import lotto.controller.Controller;
import lotto.model.Model;
import lotto.view.View;

public class MVC {
    private View view;
    private Model model;
    private Controller controller;
    public MVC(){
        view = new View();
        model = new Model();
        controller = new Controller();

        controller.association(view, model);
    }
    public void start(){
        controller.start();
    }

}
