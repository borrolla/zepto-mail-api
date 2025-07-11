package com.mail.zepto.mail_api.requestBody;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class AppOrder {
    UUID id;
    LocalDateTime placedTime;
    AppUser customer;
    AppUser deliveryPartner;
    double totalAmount;
    List<Product> products;

}
