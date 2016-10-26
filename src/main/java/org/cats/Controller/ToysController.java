package org.cats.Controller;

import javax.validation.Valid;

import org.cats.DataTransferObjects.ToyDTO;
import org.cats.Model.Toy;
import org.cats.Service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToysController {

	@Autowired
	protected ToyService toySvc;
	
	@RequestMapping("toyDetails-{id}")
	public String toyDetails(@PathVariable("id") int id, Model model){
		model.addAttribute("toy", toySvc.getToyById(id));
		//model.addAttribute("toyService", toySvc); //-> usuwa³o zabawki przy prze³adowaniu strony
		return "toyDetails";
	}
	
	@RequestMapping(value="/addToy", method=RequestMethod.GET)
    public String addToyForm(@ModelAttribute("toyDTO") ToyDTO toyDTO){
        return "addToy";
    }

    @RequestMapping(value="/addToy", method=RequestMethod.POST)
    public String handleAddToyForm(@ModelAttribute("toyDTO") @Valid ToyDTO toyDTO, BindingResult result) {
        if(!result.hasErrors())
        {
            Toy toy = new Toy();
            toy.setName(toyDTO.getName());
            toy.setDescription(toyDTO.getDescription());
            toySvc.addToy(toy);

            return "redirect:/listOfCats"; //should be toyDetails-{id}
        }

        else
            return "addToy";
    }
}
