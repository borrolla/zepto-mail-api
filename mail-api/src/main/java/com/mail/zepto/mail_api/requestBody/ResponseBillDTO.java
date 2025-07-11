package com.mail.zepto.mail_api.requestBody;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ResponseBillDTO {

    UUID orderId;
    LocalDateTime orderPlacedTime;
    List<ResponseBillProductDTO> products;
    double totalBillPayed;

}

