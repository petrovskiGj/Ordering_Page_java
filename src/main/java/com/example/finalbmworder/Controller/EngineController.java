package com.example.finalbmworder.Controller;


import com.example.finalbmworder.Dto.EngineDto;
import com.example.finalbmworder.Model.Engine;
import com.example.finalbmworder.Model.Enum.EngineFuelType;
import com.example.finalbmworder.Model.Enum.EngineModelType;
import com.example.finalbmworder.Model.Enum.EngineShifterType;
import com.example.finalbmworder.Service.EngineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EngineController {
    private final EngineService engineService;
@Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }
    @GetMapping({"/engines"})
    public String listEngines(Model model){
        List<EngineDto> engines = engineService.listAllEngines();
        model.addAttribute("engines",engines);
        return "ListEngines";
    }
    @GetMapping("/engines/search")
    public String searchEngines(@RequestParam(value="query") String query, Model model){
        List<EngineDto> engines = engineService.searchEngines(query);
        model.addAttribute("engines",engines);
        return "ListEngines";
    }
    @GetMapping("/engines/{engineId}")
    public String engineDetail(@PathVariable("engineId") long engineId, Model model) {

        EngineDto engineDto = engineService.findById(engineId);
        model.addAttribute("engine", engineDto);
        return "DetailsEngine";
    }

    @GetMapping("/engines/add")
    public String addEngines(Model model){
        Engine engine = new Engine();
        model.addAttribute("engine",engine);
        model.addAttribute("engineFuelType", EngineFuelType.values());
        model.addAttribute("engineModelType", EngineModelType.values());
        model.addAttribute("engineShifterType", EngineShifterType.values());
        return "CreateEngines";
    }
    @PostMapping("/engines/add")
    public String CreateEngine(@Valid @ModelAttribute("engine")
                            EngineDto engine,
                            BindingResult result,
                            Model model){
        if(result.hasErrors()){
            model.addAttribute("engine",engine);
            model.addAttribute("engineFuelType", EngineFuelType.values());
            model.addAttribute("engineModelType", EngineModelType.values());
            model.addAttribute("engineShifterType", EngineShifterType.values());
            return "CreateEngines";
        }
        this.engineService.create(engine);
        return "redirect:/engines";
    }
    @GetMapping("/engines/{engineId}/edit")
    public String editEngine(@PathVariable("engineId") Long engineId,
                                Model model){
    EngineDto engineDto = engineService.findById(engineId);
    model.addAttribute("engine",engineDto);
        model.addAttribute("engineFuelType", EngineFuelType.values());
        model.addAttribute("engineModelType", EngineModelType.values());
        model.addAttribute("engineShifterType", EngineShifterType.values());
    return "EditEngines";
    }
    @PostMapping("/engines/{engineId}/edit")
    public String updateEngine(@PathVariable("engineId") Long engineId,
                               @Valid @ModelAttribute("engine") EngineDto engine,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "EditEngines";
        }
        engine.setId(engineId);
        engineService.update(engine);
        return "redirect:/engines";

    }
    @GetMapping("/engines/{engineId}/delete")
    public String deleteEngine(@PathVariable ("engineId") Long engineId){
        engineService.delete(engineId);
        return "redirect:/engines";
    }
}
