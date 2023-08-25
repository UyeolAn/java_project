package co.yedam.hello;

import co.yedam.hello.menu.ProductManager;

public class App 
{
    public static void main( String[] args )
    {
        ProductManager manager = new ProductManager();
        manager.run();
    }
}
