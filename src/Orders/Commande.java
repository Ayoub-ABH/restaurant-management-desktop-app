package Orders;

import Dishes.Dish;
import Persons.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Commande implements Serializable {

    private static final long serialVersionUID = 6L;
    private ArrayList<Dish> dishes = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();
    private Order order;
    private Customer customer;
    private int nbr;


    public Commande(ArrayList<Dish> dishes, ArrayList<Integer> quantities, Order order, Customer customer, int nbr) {
        this.dishes = dishes;
        this.quantities = quantities;
        this.order = order;
        this.customer = customer;
        this.nbr = nbr;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
