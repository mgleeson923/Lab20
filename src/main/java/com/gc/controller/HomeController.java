package com.gc.controller;

/**
 * Created by michaelgleeson on 7/21/17.
 */


import com.test.mappings.ItemsEntity;
import com.test.mappings.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {
        String name = "Michael's Coffee Shop";
        return new
                ModelAndView("welcome","name", name);

    }



    @RequestMapping("/form")
    //String method returns the jsp Page that we want to show
    public String htmlForm() {

        return "htmlform";
    }

    @RequestMapping("/success")
    //Model is a parameter that allows us to add stuff to our jsp pages
    //RequestParam allows us to take in data from the form -- we must assign a type and variable name with it
    public String formSuccess(Model model, @RequestParam("c_name") String name, @RequestParam("c_lastname") String lastName, @RequestParam("c_email") String eMail,
                              @RequestParam("c_phone") String phoneNumber, @RequestParam("c_password") String password) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        UsersEntity newCustomer = new UsersEntity();

        newCustomer.setFirstName(name);
        newCustomer.setLastName(lastName);
        newCustomer.setEmail(eMail);
        newCustomer.setPhoneNumber(phoneNumber);
        newCustomer.setPassword(password);

        session.save(newCustomer);
        transaction.commit();
        session.close();

        model.addAttribute("userName", name);

        return "formsuccess";
    }

    @RequestMapping("/listitems")

    public ModelAndView listItems() {
        ArrayList<ItemsEntity> itemsList = getAllItems();


        return new
                ModelAndView("welcome", "cList", itemsList);
    }

    //extracted method to be used again
    //regular method, not a Controller method
    private ArrayList<ItemsEntity> getAllItems() {
        //allow app to specify properties & mapping documents
        //use when creating the SessionFactory
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session selectCustomers = sessionFactory.openSession();

        selectCustomers.beginTransaction();

        Criteria criteria = selectCustomers.createCriteria(ItemsEntity.class);

        return (ArrayList<ItemsEntity>) criteria.list();
    }

    @RequestMapping("/adminpage")
    //String method returns the jsp Page that we want to show
    public String adminPage() {

        return "adminpage";
    }

    @RequestMapping("/listusers")

    public ModelAndView listUsers() {
        ArrayList<UsersEntity> usersList = getAllUsers();


        return new
                ModelAndView("listusers", "userList", usersList);
    }

    //extracted method to be used again
    //regular method, not a Controller method
    private ArrayList<UsersEntity> getAllUsers() {
        //allow app to specify properties & mapping documents
        //use when creating the SessionFactory
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session selectCustomers = sessionFactory.openSession();

        selectCustomers.beginTransaction();

        Criteria criteria = selectCustomers.createCriteria(UsersEntity.class);

        return (ArrayList<UsersEntity>) criteria.list();
    }

    @RequestMapping("/delete")

    public ModelAndView deleteCustomer(@RequestParam("id") String id) {
        //temp object will store info for the object we want to delete
        UsersEntity temp = new UsersEntity();

        temp.setFirstName(id);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session customers = sessionFactory.openSession();

        customers.beginTransaction();

        customers.delete(temp); //delete object from list

        customers.getTransaction().commit(); //delete the row from the database table

        ArrayList<UsersEntity> userList = getAllUsers();

        return new ModelAndView("adminpage", "userList", userList);
    }


}