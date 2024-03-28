package com.example.finalbmworder.Controller;

import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Dto.InteriorDto;
import com.example.finalbmworder.Dto.ManufacturerDto;
import com.example.finalbmworder.Model.Enum.InteriorSeatType;
import com.example.finalbmworder.Model.Enum.InteriorTrimType;
import com.example.finalbmworder.Model.Interior;
import com.example.finalbmworder.Model.Manufacturer;
import com.example.finalbmworder.Service.InteriorService;
import com.example.finalbmworder.Service.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class ManufacturerController {
    private final ManufacturerService manufacturerService;
    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }


    @GetMapping("/manufacturers")
    public String listManufacturers(@RequestParam(required = false) Double userLatitude,
                                    @RequestParam(required = false) Double userLongitude,
                                    Model model) {
        List<ManufacturerDto> manufacturers;
        if (userLatitude != null && userLongitude != null) {
            ManufacturerDto nearestManufacturer = this.manufacturerService.findNearestManufacturer(userLatitude, userLongitude);
            manufacturers = Collections.singletonList(nearestManufacturer);
        } else {
            manufacturers = this.manufacturerService.listAllManufacturer();
        }
        model.addAttribute("manufacturers", manufacturers);

        return "ListManufacturer";
    }


    @GetMapping("/manufacturers/{manufacturerId}")
    public String manufacturerDetail(@PathVariable("manufacturerId") long manufacturerId, Model model) {

        ManufacturerDto manufacturerDto = manufacturerService.findById(manufacturerId);
        model.addAttribute("manufacturer", manufacturerDto);
        return "DetailsManufacturer";
    }

    @GetMapping("/manufacturers/add")
    public String addManufacturers(Model model){
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("manufacturer",manufacturer);
        return "CreateManufacturer";
    }
    @PostMapping("/manufacturers/add")
    public String CreateManufacturer(@Valid @ModelAttribute("manufacturer")
                                 ManufacturerDto manufacturer,
                                 BindingResult result,
                                 Model model){
        if(result.hasErrors()){
            model.addAttribute("manufacturer",manufacturer);
            return "CreateManufacturer";
        }
        this.manufacturerService.create(manufacturer);
        return "redirect:/manufacturers";
    }
    @GetMapping("/manufacturers/{manufacturerId}/edit")
    public String editManufacturer(@PathVariable("manufacturerId") Long manufacturerId,
                               Model model){
        ManufacturerDto manufacturer = manufacturerService.findById(manufacturerId);
        model.addAttribute("manufacturer",manufacturer);
        return "EditManufacturer";
    }
    @PostMapping("/manufacturers/{manufacturerId}/edit")
    public String updateManufacturer(@PathVariable("manufacturerId") Long manufacturerId,
                                 @Valid @ModelAttribute("manufacturer") ManufacturerDto manufacturer,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "EditManufacturer";
        }
        manufacturer.setId(manufacturerId);
        manufacturerService.update(manufacturer);
        return "redirect:/manufacturers";

    }
    @GetMapping("/manufacturers/{manufacturerId}/delete")
    public String deleteManufacturer(@PathVariable ("manufacturerId") Long manufacturerId){
        manufacturerService.delete(manufacturerId);
        return "redirect:/manufacturers";
    }
}
