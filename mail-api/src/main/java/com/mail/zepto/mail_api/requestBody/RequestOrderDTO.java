package com.mail.zepto.mail_api.requestBody;

import lombok.Data;

@Data
public class RequestOrderDTO {
    AppUser customer;
    AppUser deliveryPartner;
    ResponseBillDTO bill;
    AppOrder order;
}
