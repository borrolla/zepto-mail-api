package com.mail.zepto.mail_api.controller;


import com.mail.zepto.mail_api.requestBody.RequestOrderDTO;
import com.mail.zepto.mail_api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail/delivery-partner")
public class DeliveryPartnerController {

    @Autowired
    MailService mailService;


    @PutMapping("/order/notify")
    public String orderNotification(@RequestBody RequestOrderDTO requestOrderDTO) throws Exception{

        mailService.sendOrderNotificationToDeliveryPartner(requestOrderDTO);
        return "Success";

    }

    //when delivery partner will click accept button then customer should get mail
    //hey you delivery is assigned to this delivery partner he will be available in 10 mins
    //Delivery partner -> Congratulations order is assigned to you deliver at this address in 10 minutes
    @PutMapping("/order/accept/notify")
    public String acceptMail(@RequestBody RequestOrderDTO requestOrderDTO) throws Exception{

        mailService.notifyCustomerForOrderAssignment(requestOrderDTO);
        mailService.notifyDeliveryPartnerForOrderAcceptance(requestOrderDTO);
        return "Success";
    }
}

