package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {
    private final List<Car> list;

    {
        list = new ArrayList<>();
        list.add(new Car("name1", 1, "country1"));
        list.add(new Car("name2", 2, "country2"));
        list.add(new Car("name3", 3, "country3"));
        list.add(new Car("name4", 4, "country4"));
        list.add(new Car("name5", 5, "country5"));
    }
    @Override
    public List<Car> getCars() {
        return list;
    }
}
