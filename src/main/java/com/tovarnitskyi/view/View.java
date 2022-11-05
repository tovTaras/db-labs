package com.tovarnitskyi.view;

import com.tovarnitskyi.controller.impl.*;
import com.tovarnitskyi.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class View {
    private static final String KEY_EXIT = "Q";
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<>();

    private final CarController carController = new CarController();
    private final Car_has_dealershipController car_has_dealershipController = new Car_has_dealershipController();
    private final CharacteristicsController characteristicsController = new CharacteristicsController();
    private final CustomerController customerController = new CustomerController();
    private final DealershipController dealershipController = new DealershipController();
    private final OrderController orderController = new OrderController();
    private final SellerController sellerController = new SellerController();

    public View(){
        menu.put("11", this::getAllCar);
        menu.put("12", this::getCarById);
        menu.put("13", this::createCar);
        menu.put("14", this::updateCar);
        menu.put("15", this::deleteCar);

        menu.put("21", this::getAllCar_has_dealership);
        menu.put("22", this::getCar_has_dealershipById);
        menu.put("23", this::createCar_has_dealership);
        menu.put("24", this::updateCar_has_dealership);
        menu.put("25", this::deleteCar_has_dealership);

        menu.put("31", this::getAllCharacteristics);
        menu.put("32", this::getCharacteristicsById);
        menu.put("33", this::createCharacteristics);
        menu.put("34", this::updateCharacteristics);
        menu.put("35", this::deleteCharacteristics);

        menu.put("41", this::getAllCustomer);
        menu.put("42", this::getCustomerById);
        menu.put("43", this::createCustomer);
        menu.put("44", this::updateCustomer);
        menu.put("45", this::deleteCustomer);

        menu.put("51", this::getAllDealership);
        menu.put("52", this::getDealershipById);
        menu.put("53", this::createDealership);
        menu.put("54", this::updateDealership);
        menu.put("55", this::deleteDealership);

        menu.put("61", this::getAllOrder);
        menu.put("62", this::getOrderById);
        menu.put("63", this::createOrder);
        menu.put("64", this::updateOrder);
        menu.put("65", this::deleteOrder);

        menu.put("71", this::getAllSeller);
        menu.put("72", this::getSellerById);
        menu.put("73", this::createSeller);
        menu.put("74", this::updateSeller);
        menu.put("75", this::deleteSeller);

    }
    private void getAllCar() throws SQLException {
        carController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getCarById() throws SQLException {
        out.println(carController.findById(getId()));
        massageItsAll();
    }
    private void createCar() throws SQLException {
        carController.create(getCarFromInput());
        massageCreated();
    }
    private void updateCar() throws SQLException {
        Integer id = getId();
        Car car = getCarFromInput();
        car.setId(id);
        carController.update(car.getId(), car);
        massageUpdate();
    }
    private void deleteCar() throws SQLException {
        carController.delete(getId());
        massageDeleted();
    }
    private Car getCarFromInput() {
        out.println("Seller_id: ");
        Integer seller_id = Integer.parseInt(scanner.nextLine());
        out.println("class_of_car: ");
        String class_of_car = scanner.nextLine();
        out.println("Brand:");
        String brand = scanner.nextLine();
        out.println("Model");
        String model = scanner.nextLine();
        out.println("is_sold:");
        Boolean is_sold = Boolean.parseBoolean(scanner.nextLine());
        return new Car(seller_id, class_of_car, brand, model, is_sold);

    }
//chd
    private void getAllCar_has_dealership() throws SQLException {
        car_has_dealershipController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getCar_has_dealershipById() throws SQLException {
        out.println(car_has_dealershipController.findById(getId()));
        massageItsAll();
    }
    private void createCar_has_dealership() throws SQLException {
        car_has_dealershipController.create(getCar_has_dealershipFromInput());
        massageCreated();
    }
    private void updateCar_has_dealership() throws SQLException {
        Integer id = getId();
        Car_has_dealership car_has_dealership = getCar_has_dealershipFromInput();
        car_has_dealership.setId(id);
        car_has_dealershipController.update(car_has_dealership.getId(), car_has_dealership);
        massageUpdate();
    }
    private void deleteCar_has_dealership() throws SQLException {
        car_has_dealershipController.delete(getId());
        massageDeleted();
    }
    private Car_has_dealership getCar_has_dealershipFromInput() {
        out.println("car_id: ");
        Integer car_id = Integer.parseInt(scanner.nextLine());
        out.println("dealership_id: ");
        Integer dealership_id = Integer.parseInt(scanner.nextLine());

        return new Car_has_dealership(car_id, dealership_id);

    }
//
    private void getAllCharacteristics() throws SQLException {
        characteristicsController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getCharacteristicsById() throws SQLException {
        out.println(characteristicsController.findById(getId()));
        massageItsAll();
    }
    private void createCharacteristics() throws SQLException {
        characteristicsController.create(getCharacteristicsFromInput());
        massageCreated();
    }
    private void updateCharacteristics() throws SQLException {
        Integer id = getId();
        Characteristics characteristics = getCharacteristicsFromInput();
        characteristics.setId(id);
        characteristicsController.update(characteristics.getId(), characteristics);
        massageUpdate();
    }
    private void deleteCharacteristics() throws SQLException {
        characteristicsController.delete(getId());
        massageDeleted();
    }
    private Characteristics getCharacteristicsFromInput() {
        out.println("Car_id: ");
        Integer car_id = Integer.parseInt(scanner.nextLine());
        out.println("serial_number: ");
        String serial_number = scanner.nextLine();
        out.println("is_new:");
        Boolean is_new = Boolean.parseBoolean(scanner.nextLine());
        out.println("engine");
        String engine = scanner.nextLine();
        out.println("milage:");
        Integer milage = Integer.parseInt(scanner.nextLine());
        out.println("tank_volume");
        Integer tank_volume = Integer.parseInt(scanner.nextLine());
        out.println("color");
        String color = scanner.nextLine();
        out.println("maintenance");
        String maintenance = scanner.nextLine();

        return new Characteristics(car_id, serial_number, is_new, engine, milage, tank_volume, color, maintenance);

    }

    private void getAllCustomer() throws SQLException {
        customerController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getCustomerById() throws SQLException {
        out.println(customerController.findById(getId()));
        massageItsAll();
    }
    private void createCustomer() throws SQLException {
        customerController.create(getCustomerFromInput());
        massageCreated();
    }
    private void updateCustomer() throws SQLException {
        Integer id = getId();
        Customer customer = getCustomerFromInput();
        customer.setId(id);
        customerController.update(customer.getId(), customer);
        massageUpdate();
    }
    private void deleteCustomer() throws SQLException {
        customerController.delete(getId());
        massageDeleted();
    }
    private Customer getCustomerFromInput() {
        out.println("first_name: ");
        String first_name = scanner.nextLine();
        out.println("last_name: ");
        String last_name = scanner.nextLine();
        out.println("cell_phone");
        String cell_phone = scanner.nextLine();
        out.println("email");
        String email = scanner.nextLine();
        return new Customer(first_name, last_name, cell_phone, email);

    }

    private void getAllDealership() throws SQLException {
        dealershipController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getDealershipById() throws SQLException {
        out.println(dealershipController.findById(getId()));
        massageItsAll();
    }
    private void createDealership() throws SQLException {
        dealershipController.create(getDealershipFromInput());
        massageCreated();
    }
    private void updateDealership() throws SQLException {
        Integer id = getId();
        Dealership dealership = getDealershipFromInput();
        dealership.setId(id);
        dealershipController.update(dealership.getId(), dealership);
        massageUpdate();
    }
    private void deleteDealership() throws SQLException {
        dealershipController.delete(getId());
        massageDeleted();
    }
    private Dealership getDealershipFromInput() {
        out.println("Adress:");
        String adress = scanner.nextLine();
        return new Dealership(adress);
    }

    private void getAllOrder() throws SQLException {
        orderController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getOrderById() throws SQLException {
        out.println(orderController.findById(getId()));
        massageItsAll();
    }
    private void createOrder() throws SQLException {
        orderController.create(getOrderFromInput());
        massageCreated();
    }
    private void updateOrder() throws SQLException {
        Integer id = getId();
        Order order = getOrderFromInput();
        order.setId(id);
        orderController.update(order.getId(), order);
        massageUpdate();
    }
    private void deleteOrder() throws SQLException {
        orderController.delete(getId());
        massageDeleted();
    }
    private Order getOrderFromInput() {
        out.println("feedback: ");
        String feedback = scanner.nextLine();
        out.println("Seller_id: ");
        Integer seller_id = Integer.parseInt(scanner.nextLine());
        out.println("Seller_id: ");
        Integer customer_id = Integer.parseInt(scanner.nextLine());

        return new Order(feedback, seller_id, customer_id);
    }

    private void getAllSeller() throws SQLException {
        sellerController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getSellerById() throws SQLException {
        out.println(sellerController.findById(getId()));
        massageItsAll();
    }
    private void createSeller() throws SQLException {
        sellerController.create(getSellerFromInput());
        massageCreated();
    }
    private void updateSeller() throws SQLException {
        Integer id = getId();
        Seller seller = getSellerFromInput();
        seller.setId(id);
        sellerController.update(seller.getId(), seller);
        massageUpdate();
    }
    private void deleteSeller() throws SQLException {
        sellerController.delete(getId());
        massageDeleted();
    }
    private Seller getSellerFromInput() {
        out.println("first_name: ");
        String first_name = scanner.nextLine();
        out.println("last_name: ");
        String last_name = scanner.nextLine();
        out.println("cell_phone");
        String cell_phone = scanner.nextLine();
        out.println("email");
        String email = scanner.nextLine();
        out.println("adress");
        String adress = scanner.nextLine();
        return new Seller(first_name, last_name, cell_phone, email, adress);

    }


    private Integer getId() {
        out.println("Id:");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private String getName() {
        out.println("Name:");
        return scanner.nextLine();
    }

    private void massageItsAll() {
        out.println("----------------------------------------\n"
                + "That's all!\n"
                + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageDeleted() {
        out.println("Deleted!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageCreated() {
        out.println("Created!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageUpdate() {
        out.println("Update!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private static void displayMenu() {
        out.println(
                "|--------------------------------------|---------------|\n" +
                        "| 1: car                               |   1: GET ALL  |\n" +
                        "| 2: enterprise                        |   2: GET      |\n" +
                        "| 3: city                              |   3: CREATE   |\n" +
                        "| 4: district                          |   4: UPDATE   |\n" +
                        "| 5: street address                    |   5: DELETE   |\n" +
                        "| 6: parking                           |_______________|\n" +
                        "| 7: parking reservation               |               |\n" +
                        "| 8: user card                         |               |\n" +
                        "| 9: parking story                     |   Q - exit    |\n" +
                        "|--------------------------------------|---------------|\n"
        );
    }

    public void show() throws SQLException {
        displayMenu();
        out.println("Select a table and action: ");
        String input = scanner.nextLine();

        while (!input.equals(KEY_EXIT)) {
            out.println("----------------------------------------");
            menu.get(input).print();
            input = scanner.nextLine();
        }
    }

}
