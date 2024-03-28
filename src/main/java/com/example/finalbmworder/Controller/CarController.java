package com.example.finalbmworder.Controller;

import com.example.finalbmworder.Dto.CarDto;
import com.example.finalbmworder.Dto.EngineDto;
import com.example.finalbmworder.Dto.ManufacturerDto;
import com.example.finalbmworder.Model.Car;
import com.example.finalbmworder.Model.Enum.CarType;
import com.example.finalbmworder.Service.CarService;
import com.example.finalbmworder.Service.EngineService;
import com.example.finalbmworder.Service.ExteriorService;
import com.example.finalbmworder.Service.InteriorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    private final InteriorService interiorService;
    private final ExteriorService exteriorService;
    private final EngineService engineService;

    @Autowired
    public CarController(CarService carService, InteriorService interiorService, ExteriorService exteriorService, EngineService engineService) {
        this.carService = carService;
        this.interiorService = interiorService;
        this.exteriorService = exteriorService;
        this.engineService = engineService;
    }




    @GetMapping("/cars")
    public String showList(Model model)
    {
        List<CarDto> cars = carService.listAllCars();
        model.addAttribute("cars",cars);
        model.addAttribute("interiors", interiorService.listAllInterior());
        model.addAttribute("exteriors", exteriorService.listAllExteriors());
        model.addAttribute("engines", engineService.listAllEngines());
        model.addAttribute("types",CarType.values());
        return "ListCars";
    }



    @GetMapping("/cars/{carId}")
    public String carDetail(@PathVariable("carId") long carId, Model model) {

        CarDto carDto = carService.findById(carId);
        model.addAttribute("car", carDto);
        model.addAttribute("interiors", interiorService.listAllInterior());
        model.addAttribute("exteriors", exteriorService.listAllExteriors());
        model.addAttribute("engines", engineService.listAllEngines());
        model.addAttribute("types",CarType.values());

        return "DetailsCars";
    }

    @GetMapping("/cars/add")
    public String addCars(Model model){
        Car car = new Car();
        model.addAttribute("car",car);
        model.addAttribute("interiors", interiorService.listAllInterior());
        model.addAttribute("exteriors", exteriorService.listAllExteriors());
        model.addAttribute("engines", engineService.listAllEngines());
        model.addAttribute("types",CarType.values());


        return "CreateCars";
    }
    @PostMapping("/cars/add")
    public String CreateCar(@Valid @ModelAttribute("car")
                                     CarDto car,
                                     BindingResult result,
                                     Model model){
        if(result.hasErrors()){
            model.addAttribute("car",car);
            model.addAttribute("interiors", interiorService.listAllInterior());
            model.addAttribute("exteriors", exteriorService.listAllExteriors());
            model.addAttribute("engines", engineService.listAllEngines());
            model.addAttribute("types",CarType.values());

            return "CreateCars";
        }
        this.carService.create(car);
        return "redirect:/cars";
    }
    @GetMapping("/cars/{carId}/edit")
    public String editCar(@PathVariable("carId") Long carId,
                                   Model model){
        CarDto car = carService.findById(carId);
        model.addAttribute("car",car);
        model.addAttribute("interiors", interiorService.listAllInterior());
        model.addAttribute("exteriors", exteriorService.listAllExteriors());
        model.addAttribute("engines", engineService.listAllEngines());
        model.addAttribute("types",CarType.values());

        return "EditCars";
    }
    @PostMapping("/cars/{carId}/edit")
    public String updateCar(@PathVariable("carId") Long carId,
                                     @Valid @ModelAttribute("car") CarDto car,
                                     BindingResult result) {
        if (result.hasErrors()) {
            return "EditCars";
        }
        car.setId(carId);
        carService.update(car);
        return "redirect:/cars";

    }
    @GetMapping("/cars/{carId}/delete")
    public String deleteCar(@PathVariable ("carId") Long carId){
        carService.delete(carId);
        return "redirect:/cars";
    }
}
