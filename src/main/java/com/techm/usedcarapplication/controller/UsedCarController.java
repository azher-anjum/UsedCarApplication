package com.techm.usedcarapplication.controller;

import com.techm.usedcarapplication.entity.Appointment;
import com.techm.usedcarapplication.entity.Car;
import com.techm.usedcarapplication.repo.AppointmentRepo;
import com.techm.usedcarapplication.repo.CarRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Changed
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;

@Controller // This MUST be @Controller for ModelAndView/JSP to work
public class UsedCarController {

    @Autowired
    private CarRepo carRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/addcar")
    public ModelAndView addCar() {
        return new ModelAndView("addcar");
    }

    @PostMapping("/submitcar")
    public RedirectView submitCar(@ModelAttribute Car car) {
        carRepo.save(car);
        return new RedirectView("/viewcars");
    }

    @GetMapping("/viewcars")
    public ModelAndView viewCars() {
        ModelAndView modelAndView = new ModelAndView("viewcars");
        modelAndView.addObject("cars", carRepo.findAll());
        return modelAndView;
    }

    // ... (Keep all other methods as they are)
}