package com.techm.usedcarapplication.controller;

import com.techm.usedcarapplication.aop.LoggingAspect;
import com.techm.usedcarapplication.entity.Appointment;
import com.techm.usedcarapplication.entity.Car;
import com.techm.usedcarapplication.repo.AppointmentRepo;
import com.techm.usedcarapplication.repo.CarRepo;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsedCarController {

    @Autowired
    private CarRepo carRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private LoggingAspect loggingAspect;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/addcar")
    public ModelAndView addCar() {
        return new ModelAndView("addcar");
    }


    @PostMapping("/submitcar")
    public RedirectView submitCar(@ModelAttribute Car car) throws Exception {
        carRepo.save(car);
        return new RedirectView("/viewcars");
    }

    @GetMapping("/addappointment")
    public ModelAndView addAppointment() {
    	ModelAndView mv = new ModelAndView("addappointment");
    	mv.addObject("cars", carRepo.findAll());
        return mv;
    }
    
    @PostMapping("/submitappointment")
    public RedirectView submitAppointment(@ModelAttribute Appointment appointment) {
        if (!appointment.getType().equals("Test Drive"))
    	    appointment.setCar(null);
    	appointmentRepo.save(appointment);
    	return new RedirectView("/viewappointments");
    }

    @GetMapping("/viewcars")
    public ModelAndView viewCars() {
        ModelAndView modelAndView = new ModelAndView("viewcars");
        modelAndView.addObject("cars", carRepo.findAll());
        return modelAndView;
    }

    @GetMapping("/viewcars/{id}")
    public ModelAndView viewCars(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("car");
        modelAndView.addObject("car", carRepo.getReferenceById(id));
        return modelAndView;
    }

    @RequestMapping("/updatecar/{id}")
    public ModelAndView updateCar(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("updatecar");
        modelAndView.addObject("car", carRepo.getReferenceById(id));
        return modelAndView;
    }

    @PostMapping("updatingcar")
    public RedirectView updatingAppointment(@ModelAttribute Car car) {
        carRepo.save(car);
        return new RedirectView("/viewcars");
    }

    @RequestMapping ("/deletecar/{id}")
    public RedirectView deleteCar(@PathVariable("id") int id) {
        carRepo.deleteById(id);
        return new RedirectView("/viewcars");
    }
    
    @GetMapping("/viewappointments")
    public ModelAndView viewAppointments() {
    	ModelAndView modelAndView = new ModelAndView("viewappointments");
        modelAndView.addObject("appointments", appointmentRepo.findAll());
        return modelAndView;
    }

    @GetMapping("/viewappointments/{id}")
    public ModelAndView viewAppointments(@PathVariable("id") int id) {
    	ModelAndView modelAndView = new ModelAndView("appointment");
        modelAndView.addObject("appointment", appointmentRepo.getReferenceById(id));
        return modelAndView;
    }

    @RequestMapping("/updateappointment/{id}")
    public ModelAndView updateAppointment(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("updateappointment");
        modelAndView.addObject("appointment", appointmentRepo.getReferenceById(id));
        modelAndView.addObject("cars", carRepo.findAll());
        return modelAndView;
    }

    @PostMapping("updatingappointment")
    public RedirectView updatingAppointment(@ModelAttribute Appointment appointment) {
        if (!appointment.getType().equals("Test Drive"))
            appointment.setCar(null);

        appointmentRepo.save(appointment);
        return new RedirectView("/viewappointments");
    }

    @RequestMapping ("/deleteappointment/{id}")
    public RedirectView deleteAppointment(@PathVariable("id") int id) {
        appointmentRepo.deleteById(id);
        return new RedirectView("/viewappointments");
    }

    @RequestMapping("/search")
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView("search");

        List<Car> c = carRepo.findAll();
        List<String> fuelType = new ArrayList<>();
        List<String> brand = new ArrayList<>();
        List<Integer> seatingCapacity = new ArrayList<>();
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;

        for (Car car : c) {
            if (!fuelType.contains(car.getFuelType()))
                fuelType.add(car.getFuelType());
            if (!brand.contains(car.getCarBrand()))
                brand.add(car.getCarBrand());
            if (!seatingCapacity.contains(car.getCapacity()))
                seatingCapacity.add(car.getCapacity());
            if (Integer.parseInt(car.getPrice()) > maxPrice)
                maxPrice = Integer.parseInt(car.getPrice());
            if (Integer.parseInt(car.getPrice()) < minPrice)
                minPrice = Integer.parseInt(car.getPrice());
        }

        modelAndView.addObject("fuelTypes", fuelType);
        modelAndView.addObject("brands", brand);
        modelAndView.addObject("seatingCapacity", seatingCapacity);
        modelAndView.addObject("maxPrice", maxPrice);
        modelAndView.addObject("minPrice", minPrice);


        return modelAndView;
    }

    @RequestMapping("/submitsearch")
    public ModelAndView submitSearch(HttpServletRequest request) {
        String fuelType = request.getParameter("fuelType");
        String capacity = request.getParameter("capacity");
        String carBrand = request.getParameter("brand");
        String price = request.getParameter("budget");

        List<Car> cars = carRepo.findByFuelTypeAndCapacityAndCarBrand(fuelType, Integer.parseInt(capacity), carBrand);
        if(cars.isEmpty()){
            Car car = new Car();
            car.setCarName("No cars found");
            cars.add(car);
        }
        ModelAndView modelAndView = new ModelAndView("resultsearchcar");
        modelAndView.addObject("cars", cars);
        return modelAndView;

    }

}
