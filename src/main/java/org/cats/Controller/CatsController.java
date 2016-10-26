package org.cats.Controller;

import org.cats.DataTransferObjects.CatDTO;
import org.cats.DataTransferObjects.ToyDTO;
import org.cats.Model.Cat;
import org.cats.Service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CatsController{

    @Autowired
    protected CatService catSvc;

    @RequestMapping("/")
    public String home(Model model){
        return "main";
    }

    @RequestMapping("/listOfCats")
    public String listCats(Model model) {
        model.addAttribute("cats", catSvc.getCats());
        return "listOfCats";
    }

    @RequestMapping(value="/addCat", method=RequestMethod.GET)
    public String addCatForm(@ModelAttribute("catDTO") CatDTO catDTO){
        return "addCat";
    }

    @RequestMapping(value="/addCat", method=RequestMethod.POST)
    public String handleAddCatForm(@ModelAttribute("catDTO") @Valid CatDTO catDTO, BindingResult result) {
        if(!result.hasErrors())
        {
            Cat cat = new Cat();
            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                cat.setDateOfBirth(catDTO.getDateOfBirth());
            } catch (Exception e){
                e.printStackTrace();
            }
            cat.setName(catDTO.getName());
            cat.setNameOfOwner(catDTO.getNameOfOwner());
            cat.setWeight(catDTO.getWeight());
            catSvc.addCat(cat);

            return "redirect:/listOfCats";
        }

        else
            return "addCat";
    }

    @RequestMapping(value="catDetails-{id}", method=RequestMethod.GET)
    public String getCatDetails(@ModelAttribute("toyDTO") @Valid ToyDTO tatDTO, BindingResult result, @PathVariable("id") int id, Model model) {
        model.addAttribute("cat", catSvc.getCatById(id));
        model.addAttribute("toysList", catSvc.getCatById(id).getToyList());
        return "catDetails";
    }
}
