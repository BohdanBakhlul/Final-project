package carsdb;

import carsdb.CarRepository;
import carsdb.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private CarRepository carRepository;
    private OrdersRepository ordersRepository;

    private Car currentcar = null;


    @GetMapping(path="/add")
    public @ResponseBody String addNewCar (@RequestParam String creator
            , @RequestParam String model) {

        Car n = new Car();
        n.setCreator(creator);
        n.setModel(model);
        carRepository.save(n);
        return "Saved";
    }

//    @GetMapping(path="/login")
//    public @ResponseBody String login (@RequestParam String email) {
//
//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
//        userRepository.save(n);
//        return "Saved";
//    }



    @GetMapping(path="/addorder")
    public @ResponseBody String addNewOrder (@RequestParam String city
            , @RequestParam String comments,  @RequestParam Integer amount , @RequestParam Integer car_id) {

        Orders n = new Orders();
        n.setCity(city);
        n.setComments(comments);
        n.setAmount(amount);

        Optional<Car> u = Optional.of(new Car());
        u = carRepository.findById(car_id);

        u.get().addOrders(n);

        carRepository.save(u.get());

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }
}
