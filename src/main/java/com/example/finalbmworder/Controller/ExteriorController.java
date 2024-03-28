package com.example.finalbmworder.Controller;

import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Model.Enum.ExteriorType;
import com.example.finalbmworder.Model.Exterior;
import com.example.finalbmworder.Service.ExteriorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ExteriorController {

        private final ExteriorService exteriorService;

    @Autowired
    public ExteriorController(ExteriorService exteriorService) {
        this.exteriorService = exteriorService;
    }


        @GetMapping({"/exteriors"})
        public String listExteriors(Model model){
            List<ExteriorDto> exteriors = exteriorService.listAllExteriors();
            model.addAttribute("exteriors",exteriors);
            return "ListExteriors";
        }
        @GetMapping("/exteriors/search")
        public String searchExteriors(@RequestParam(value="query") String query, Model model){
            List<ExteriorDto> exteriors = exteriorService.searchExteriors(query);
            model.addAttribute("exteriors",exteriors);
            return "ListExteriors";
        }
        @GetMapping("/exteriors/{exteriorId}")
        public String exteriorDetail(@PathVariable("exteriorId") long exteriorId, Model model) {

            ExteriorDto exteriorDto = exteriorService.findById(exteriorId);
            model.addAttribute("exterior", exteriorDto);
            return "DetailsExterior";
        }

        @GetMapping("/exteriors/add")
        public String addExteriors(Model model){
            Exterior exterior = new Exterior();
            model.addAttribute("exterior",exterior);
            model.addAttribute("exteriorType", ExteriorType.values());
            return "CreateExteriors";
        }
        @PostMapping("/exteriors/add")
        public String CreateExterior(@Valid @ModelAttribute("exterior")
                                   ExteriorDto exterior,
                                   BindingResult result,
                                   Model model){
            if(result.hasErrors()){
                model.addAttribute("exterior",exterior);
                model.addAttribute("exteriorType", ExteriorType.values());
                return "CreateExteriors";
            }
            this.exteriorService.create(exterior);
            return "redirect:/exteriors";
        }
        @GetMapping("/exteriors/{exteriorId}/edit")
        public String editExterior(@PathVariable("exteriorId") Long exteriorId,
                                 Model model){
           ExteriorDto exteriorDto = exteriorService.findById(exteriorId);
            model.addAttribute("exterior",exteriorDto);
            model.addAttribute("exteriorType", ExteriorType.values());
            return "EditExterior";
        }
        @PostMapping("/exteriors/{exteriorId}/edit")
        public String updateExterior(@PathVariable("exteriorId") Long exteriorId,
                                   @Valid @ModelAttribute("exterior") ExteriorDto exterior,
                                   BindingResult result) {
            if (result.hasErrors()) {
                return "EditExterior";
            }
            exterior.setId(exteriorId);
            exteriorService.update(exterior);
            return "redirect:/exteriors";

        }
        @GetMapping("/exteriors/{exteriorId}/delete")
        public String deleteEngine(@PathVariable ("exteriorId") Long exteriorId){
            exteriorService.delete(exteriorId);
            return "redirect:/exteriors";
        }
    }


