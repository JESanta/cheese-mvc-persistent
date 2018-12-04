package org.launchcode.controllers;


import org.launchcode.models.data.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

//    @RequestMapping(value ="add") // /category/add
//    public String add(){
//        //render an add form
//    }
//
//    @RequestMapping (value = "add", method = RequestMethod.POST)
//    public String add (){
//        // accepts post from request
//    }
}
