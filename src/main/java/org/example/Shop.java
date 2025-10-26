package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Shop {
    private Integer shopId;
    private String shopName;
    private String shopOwner;
    About about ;


    public Shop( Integer shopId, String shopName, String shopOwner, About about ) {

        this.shopId = shopId;
        this.shopName = shopName;
        this.shopOwner = shopOwner;
        this.about = about;
    }
@Setter
@Getter
    public class About{
    private  String city;
    private String address;
    private String email;

        public About(String city, String address, String email) {
            this.city = city;
            this.address = address;
            this.email = email;
        }

    @Override
    public String toString() {
        return "About{" +
                ", city='" + city + '\'' +
                "address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

    @Override
    public String toString() {
        return "Shop{" +
                "about=" + about +
                ", shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopOwner='" + shopOwner + '\'' +
                '}';
    }
}
