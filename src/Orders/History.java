package Orders;

public class History {

    private int id_client;
    private int id_order;
    private int id_dish;
    private int quantity;


    public History(int id_client, int id_order, int id_dish, int quantity) {
        this.id_client = id_client;
        this.id_order = id_order;
        this.id_dish = id_dish;
        this.quantity = quantity;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_dish() {
        return id_dish;
    }

    public void setId_dish(int id_dish) {
        this.id_dish = id_dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
