import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        boolean encontradoProducto = false;
        int index = 0;
        while( index < stock.size() && encontradoProducto == false)
        {
            Product producto = stock.get(0);
            if(producto.getID() == id)
            {
                encontradoProducto = true;
                producto.increaseQuantity(amount);
            } else {

                System.out.println("Lo siento, no se ha encontrado ningún producto con este ID");

            }
            index++;
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * with a matching ID.
     * 
     */
    public Product findProduct(int id)
    {
        boolean encontradoProducto = false;
        Product busquedaDeProducto = null;
        int index = 0;
        while( index < stock.size() && encontradoProducto == false)
        {
            Product producto = stock.get(0);
            if(producto.getID() == id)
            {
                encontradoProducto = true;
                busquedaDeProducto = producto;
            }
            index++;
        }
        return busquedaDeProducto;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        boolean encontradoProducto = false;
        int indexBusqueda = 0;
        int index = 0;
        while( index < stock.size() && encontradoProducto == false)
        {
            Product producto = stock.get(0);
            if(producto.getID() == id)
            {
                encontradoProducto = true;
                indexBusqueda = producto.getQuantity();
            }
            index++;
        }
        return  indexBusqueda;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product producto : stock) {
            System.out.println(producto.toString());
        }
    }

    /**
     * Metodo que imprime los detalles de todos los productos cuyo stock está por debajo de un determinado número que es pasado como parámetro al método.
     */
    public void underGivenNumberInStock (int productosEnStock)
    {
        boolean existenProductosEnStock = false;
        for(Product producto: stock)
        {
            if (productosEnStock > 0){
                if(producto.getQuantity() < productosEnStock)
                {
                    System.out.println(producto.toString()); 
                    existenProductosEnStock = true;
                }                 
            }
        }
        if (existenProductosEnStock == false)   {

            System.out.println("Lo siento, no se ha encontrado ningún producto");
        }
    }

}
