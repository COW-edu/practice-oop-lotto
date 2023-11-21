package lotto.view;

import java.util.Map;

public class ViewModel {

    private final String viewPath;
    private final Map<String, Object> model;

    public ViewModel(String viewPath, Map<String, Object> model) {
        this.viewPath = viewPath;
        this.model = model;
    }

    public void render() {
        try {
            OutputViewFactory viewFactory = OutputViewFactory.getInstance();
            Viewable viewable = viewFactory.get(viewPath);
            viewable.render(model);
        } catch (NullPointerException e) {

        }
    }
}
