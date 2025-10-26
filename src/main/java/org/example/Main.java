package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Shop temp = new Shop(null, "name", "owner", null);
        Shop.About about = temp.new About ("Tbilisi", "Nikoladze str", "irena@.gmail");

        Shop shopToSet = new Shop(null, "SomeShop", "Irena Sturua", about);

        ShopService shopService = new ShopService(shopToSet);
        shopService.createShop(shopToSet);
    }
}