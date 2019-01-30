package carsdb;

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
    private SpecsRepository specsRepository;
    private DeliveryRepository deliveryRepository;

    private Car defcar = null;


    @GetMapping(path="/add")
    public @ResponseBody String addNewCar (@RequestParam String creator
            , @RequestParam String model) {

        Car n = new Car();
        n.setCreator(creator);
        n.setModel(model);
        carRepository.save(n);
        return "Saved";
    }




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

    @GetMapping(path="/addspec")
    public @ResponseBody String addNewSpec (@RequestParam String body
            , @RequestParam String color,  @RequestParam Integer engine_size , @RequestParam Integer car_id) {

        Specs a = new Specs();
        a.setColor(color);
        a.setBody(body);
        a.setEngine_size(engine_size);

        Optional<Car> v = Optional.of(new Car());
        v = carRepository.findById(car_id);

        v.get().addSpecs(a);

        carRepository.save(v.get());

        return "Saved";
    }

    @GetMapping(path="/adddelivery")
    public @ResponseBody String addNewDelivery (@RequestParam String type
            ,  @RequestParam Integer quantity , @RequestParam Integer car_id) {

        Delivery x = new Delivery();
        x.setType(type);
        x.setQuantity(quantity);
        Optional<Car> v = Optional.of(new Car());
        v =carRepository.findById(car_id);

        v.get().addDeliveries(x);

        carRepository.save(v.get());

        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping(path="/delete")
    public @ResponseBody
    void deleteAllCars() {
        carRepository.deleteAll();
    }

//    @GetMapping(path="/greeting")
//    public @ResponseBody String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

}
