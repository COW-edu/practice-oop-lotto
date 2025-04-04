package viewInterface;

import model.MModel;

public abstract class OutputController implements ViewController {
    protected String message = "";

    protected OutputController() {

    }

    protected abstract void setMessage(MModel<?> model);

    @Override
    public abstract String getMessage();

}
