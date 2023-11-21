package lotto.control;

import java.util.HashMap;
import java.util.Map;
import lotto.AppConfig;
import lotto.service.Service;
import lotto.view.ViewModel;

public class FrontController {

    private final HashMap<Integer, Service> serviceHashMap = new HashMap<>();


    private AppConfig appConfig = new AppConfig();

    public FrontController() {
        serviceHashMap.put(1, appConfig.buyLottoService());
        serviceHashMap.put(2, appConfig.defineWinningLotto());
        serviceHashMap.put(3, appConfig.defineBonusService());
        serviceHashMap.put(4, appConfig.judgeMentService());
        serviceHashMap.put(5, appConfig.statisticsService());

    }

    public void run() {

        for (int i = 1; i < 6; i++) {
            service(i);
        }
    }

    public void service(Integer i) {
        Service service = serviceHashMap.get(i);
        Map<String, Object> model = new HashMap<>();
        ViewModel viewModel = new ViewModel(i.toString(), null);
        viewModel.render();
        String viewPath = service.process(model);
        viewModel = new ViewModel(viewPath, model);
        viewModel.render();
    }
}
