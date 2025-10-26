package org.example;

import lombok.RequiredArgsConstructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class ShopService {
    private final Shop shop;



    public void createShop(Shop s){
        String sql = """
            INSERT INTO shops (shop_name, shop_owner, city, address, email)
             VALUES (?, ?, ?, ?, ?)
            RETURNING shop_id
        """;
// local class use
        class ShopNotifier {
            void notify(Shop s) {
                Validator<String> emailChecker = new EmailChaker();
                String email = s.getAbout().getEmail();
               // lambdas  Used
                Consumer<String> emailAction = emailChecker.test(email)
                        ? e -> System.out.println("Email '" + e + "' is valid and saved for shop '" + s.getShopName() + "'.")
                        : e -> System.out.println("Email '" + e + "' seems invalid. Please verify it manually later.");

                System.out.println("Shop ID: " + s.getShopId());
                emailAction.accept(email);
            }
        }



        try(Connection con = DbConnectionManager.getConnectionInstance().getDbConnection();
    PreparedStatement stm = con.prepareStatement(sql)){
        stm.setString(1, shop.getShopName());
        stm.setString(2, shop.getShopOwner());
        stm.setString(3, shop.getAbout().getCity());
        stm.setString(4, shop.getAbout().getAddress());
        stm.setString(5, shop.getAbout().getEmail());
        ResultSet result = stm.executeQuery();
        while (result.next()) {
            int generatedId = result.getInt("shop_id");
            shop.setShopId(generatedId);
            new ShopNotifier().notify(shop);
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


} }
