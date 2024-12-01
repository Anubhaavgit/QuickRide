package com.comrade.QuickRide.controller;

import java.util.List;

import com.comrade.QuickRide.entities.CabDriver;
import com.comrade.QuickRide.entities.Coordinate;
import com.comrade.QuickRide.entities.User;
import com.comrade.QuickRide.ride.Validator.RideValidator;
import com.comrade.QuickRide.services.DriverServiceImpl;
import com.comrade.QuickRide.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuickRideController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	DriverServiceImpl driverService;
	@Autowired
	RideValidator rideValidator;


	/*
	To Load sample Values just to begin With for the First Time
	 */
	@GetMapping("load")
	public void load(){
		userService.loadUsers();
		driverService.loadDrivers();
	}

	@PostMapping("addUser")
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}
	@DeleteMapping("removeUser")
	public void removeUser(@RequestBody User user){
		userService.removeUser(user);
	}

	@PostMapping("addDriver")
	public void addDriver(@RequestBody CabDriver driver){
		driverService.addDriver(driver);
	}

	@DeleteMapping("removeDriver")
	public void removeDriver(@RequestBody CabDriver driver){
		driverService.removeDriver(driver);
	}

	@PostMapping("updateUserCurrentLocation/{userId}")
	public String updateUserCurrentLocation(@PathVariable int userId, @RequestBody Coordinate currentLocation){
		return userService.updateUserLocation(userId,currentLocation);
	}
	@GetMapping("getDrivers")
	public List<CabDriver> getDrivers(){
		return driverService.getList();
	}

	@GetMapping("getUsers")
	public List<User> getUsers(){
		return userService.getList();
	}

	@GetMapping("getUser/{userId}")
	public User getUser(@PathVariable int userId){
         return userService.getUserById(userId);
    }

	@GetMapping("getDriver/{driverId}")
	public CabDriver getDriver(@PathVariable int driverId){
		return driverService.getDriverById(driverId);
	}
	@PostMapping("findRide/{userId}")
	public String findRide(@PathVariable int userId, @RequestBody Coordinate destination){
		return userService.findRide(userId, destination);
	}

	@GetMapping("validateRide")
	public void validateRide(){
		List<CabDriver> drivers = getDrivers();
		List<User> users= getUsers();
		rideValidator.rideValidation(users, drivers);
	}
	@GetMapping("getEarnings")
	public int getEarnings(@RequestBody CabDriver driver){
		return driver.getEarnings();
	}
}
