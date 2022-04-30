package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getCars(int count) {//10
        if (count == 0) {
            return carDao.getCars();
        }
        return carDao.getCars().stream().limit(count).collect(Collectors.toList());
    }
}
