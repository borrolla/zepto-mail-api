package com.mail.zepto.mail_api.requestBody;


import lombok.Data;

import java.util.UUID;
@Data
public class ResponseBillProductDTO {
    UUID productId;
    String productName;
    int quantity;
    double amount;
}
