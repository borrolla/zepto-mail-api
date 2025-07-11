package com.mail.zepto.mail_api.requestBody;

import lombok.Data;

import java.util.UUID;


@Data
public class Product {

        UUID id;
        String productName;
        int productPrice;
        String details;
        String manufacturerEmail;
        Double rating;
        int weight;
        int totalPurchase;
    }

