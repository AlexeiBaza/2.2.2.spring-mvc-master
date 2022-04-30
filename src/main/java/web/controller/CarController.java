package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;
import web.service.CarServiceImpl;

import java.util.Optional;

@Controller
public class CarController {
    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model,
                            @RequestParam(value = "count", required = false) Optional<Integer> count) {
        /*получаем машины и положили их в model чтобы передать
        их в представление. Под ключем "cars" лежит список из машин*/
        model.addAttribute("cars", carServiceImpl.getCars(count.orElse(0)));
        return "Cars";
    }
}
