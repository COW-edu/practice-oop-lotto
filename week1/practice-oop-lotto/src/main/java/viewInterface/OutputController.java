package viewInterface;

import model.MModel;

public abstract class OutputController implements ViewController {
    protected String message = "";

    protected OutputController() {

    }

    public abstract void setMessage(MModel<?> model);

    @Override
    public String getMessage(){
        return message;
    }

}
