package com.example.finalbmworder.Controller;
import com.example.finalbmworder.Dto.InteriorDto;
import com.example.finalbmworder.Model.Enum.InteriorSeatType;
import com.example.finalbmworder.Model.Enum.InteriorTrimType;
import com.example.finalbmworder.Model.Interior;
import com.example.finalbmworder.Service.InteriorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InteriorController {
    private final InteriorService interiorService;
    @Autowired
    public InteriorController(InteriorService interiorService) {
        this.interiorService = interiorService;
    }
    @GetMapping({"/interiors"})
    public String listInterior(Model model){
        List<InteriorDto> interiors = interiorService.listAllInterior();
        model.addAttribute("interiors",interiors);
        return "ListInteriors";
    }
    @GetMapping("/interiors/search")
    public String searchInteriors(@RequestParam(value="query") String query, Model model){
        List<InteriorDto> interiors = interiorService.searchInterior(query);
        model.addAttribute("interiors",interiors);
        return "ListInteriors";
    }
    @GetMapping("/interiors/{interiorId}")
    public String interiorDetail(@PathVariable("interiorId") long interiorId, Model model) {

        InteriorDto interiorDto = interiorService.findById(interiorId);
        model.addAttribute("interior", interiorDto);
        return "DetailsInterior";
    }

    @GetMapping("/interiors/add")
    public String addInteriors(Model model){
        Interior interior = new Interior();
        model.addAttribute("interior",interior);
        model.addAttribute("InteriorTrimType", InteriorTrimType.values());
        model.addAttribute("InteriorSeatType", InteriorSeatType.values());
        return "CreateInteriors";
    }
    @PostMapping("/interiors/add")
    public String CreateInterior(@Valid @ModelAttribute("interior")
                               InteriorDto interior,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            model.addAttribute("interior",interior);
            model.addAttribute("InteriorTrimType", InteriorTrimType.values());
            model.addAttribute("InteriorSeatType", InteriorSeatType.values());
            return "CreateInteriors";
        }
        this.interiorService.create(interior);
        return "redirect:/interiors";
    }
    @GetMapping("/interiors/{interiorId}/edit")
    public String editInterior(@PathVariable("interiorId") Long interiorId,
                             Model model){
        InteriorDto interiorDto = interiorService.findById(interiorId);
        model.addAttribute("interior",interiorDto);
        model.addAttribute("InteriorTrimType", InteriorTrimType.values());
        model.addAttribute("InteriorSeatType", InteriorSeatType.values());
        return "EditInteriors";
    }
    @PostMapping("/interiors/{interiorId}/edit")
    public String updateInterior(@PathVariable("interiorId") Long interiorId,
                               @Valid @ModelAttribute("interior") InteriorDto interior,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "EditInteriors";
        }
        interior.setId(interiorId);
        interiorService.update(interior);
        return "redirect:/interiors";

    }
    @GetMapping("/interiors/{interiorId}/delete")
    public String deleteInterior(@PathVariable ("interiorId") Long interiorId){
        interiorService.delete(interiorId);
        return "redirect:/interiors";
    }
}
