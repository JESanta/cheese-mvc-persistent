package org.launchcode.controllers;


import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "category")
public class CategoryController {
    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping (value = "") // /category/
    public String index(Model templateVariables) {
        // list all categories

        // 1: create a template to list categories
        // 2: provide the categories to the template (how?)
        templateVariables.addAttribute("title", " All Categories");
        templateVariables.addAttribute("categories", categoryDAO.findAll());
        // 3: render the template
        return "category/index";
    }

    @RequestMapping(value ="add") // /category/add
    public String add(Model templateVariables){
        //render an add form
        // 1: add a title
        templateVariables.addAttribute("title", "Add Category");
        // 2: add an Empty object for model binding
        templateVariables.addAttribute("category", new Category());
        return "category/add";
    }

    @RequestMapping (value = "add", method = RequestMethod.POST)
    public String add (
        Model templateVariables,
        @ModelAttribute @Valid Category category,
        Errors errors
    ){
        //1: check if the binded model has errors
        if (errors.hasErrors()) return "category/add";
        //2: (no errors) save the category object in the db
        categoryDAO.save(category);
        //3: redirect back to the category list (index) view
        return "redirect:";
        // accepts post from request
    }
}
