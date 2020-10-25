package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.Car;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase {


    @Test
    public void testFormLetTheCarWorkForLoggedInUser() throws InterruptedException {
        if(!isUserLoggedIn()){
            logIn();
        }

        openAddCarFormFromHeader();
        fillCarForm(
                new Car().setCountry("Israel").setAddress("Balfour Street").setDistance("550")
                        .setSerialNumber("987678955").setBrand("BMW").setModel("x5").setYear("2002")
                        .setEngine("V8").setFuelConsumption("8").setTransmission("automatic")
                        .setWd("wedfrt").setHorsepower("110").setTorque("3456").setDoors("4")
                        .setSeats("5").setClasss("E").setAbout("dhfhjkglglgkmfjdk")
                        .setFeature("dfghjkl").setPrice("87"));

        pause(2000);
        submitForm();

    }

    @Test
    public void testFormLetTheCarWorkForNotLoggedInUser() throws InterruptedException {
        if(isUserLoggedIn()){
            logOut();
        }
        openAddCarFormFromHeader();
        fillCarForm(
                new Car().setCountry("Israel").setAddress("Balfour Street").setDistance("550")
                        .setSerialNumber("987678955").setBrand("BMW").setModel("x5").setYear("2002")
                        .setEngine("V8").setFuelConsumption("8").setTransmission("automatic")
                        .setWd("wedfrt").setHorsepower("110").setTorque("3456").setDoors("4")
                        .setSeats("5").setClasss("E").setAbout("dhfhjkglglgkmfjdk")
                        .setFeature("dfghjkl").setPrice("87"));

        pause(2000);
        submitForm();

    }

    @Test
    public void NegativeTestAddCarWithoutDorsInfo(){
        openAddCarFormFromHeader();
        fillCarForm(
                new Car().setCountry("Israel").setAddress("Balfour Street").setDistance("550")
                        .setSerialNumber("987678956").setBrand("Mercedes").setModel("x5").setYear("2002")
                        .setEngine("V8").setFuelConsumption("8").setTransmission("automatic")
                        .setWd("wedfrt").setHorsepower("110").setTorque("3456")
                        .setSeats("5").setClasss("E").setAbout("dhfhjkglglgkmfjdk")
                        .setFeature("dfghjkl").setPrice("87"));

        submitForm();

    }

}