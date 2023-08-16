package com.goltsov.springcourse.controllers;

import com.goltsov.springcourse.dao.PersonDAO;
import com.goltsov.springcourse.models.Person;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());

        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPersonById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.showPersonById(id));

        return "people/personId";
    }

    @GetMapping("/new")
    public String getCreationForm(@ModelAttribute("person") Person person) {
        return "people/new";
    }
    /*@GetMapping("/new")
    public String getCreationForm(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }*/

    @PostMapping()
    public String createPerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/people/new";
        }

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String showEditPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.showPersonById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult,
                               @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "/people/edit";
        }

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

}
