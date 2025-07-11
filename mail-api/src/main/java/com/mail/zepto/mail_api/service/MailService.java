package com.mail.zepto.mail_api.service;

import com.mail.zepto.mail_api.requestBody.RequestOrderDTO;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;


@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendOrderNotificationToDeliveryPartner(RequestOrderDTO orderDetails) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        mimeMessageHelper.setTo(orderDetails.getDeliveryPartner().getEmail());
        mimeMessageHelper.setSubject("A new order has been placed. Please review the detail");

        // Define your base URL
        String baseUrl = "http://localhost:8082"; // Change this to your actual deployment URL


        //construct full url
        String acceptUrl = baseUrl + "/api/v1/central/order/accept"
                + orderDetails.getDeliveryPartner().getId().toString()
                + "/" + orderDetails.getBill().getOrderId();

        Context context = new Context();
        context.setVariable("deliveryPartnerName", orderDetails.getDeliveryPartner().getName());
        context.setVariable("customerName", orderDetails.getCustomer().getName());
        context.setVariable("customerPhone", orderDetails.getCustomer().getPhoneNumber());
        context.setVariable("customerAddress", orderDetails.getCustomer().getAddress());
        context.setVariable("orderId",orderDetails.getBill().getOrderId());
        context.setVariable("productList", orderDetails.getBill().getProducts());
        context.setVariable("totalBill", orderDetails.getBill().getTotalBillPayed());
        context.setVariable("acceptEndPoint", acceptUrl);


        String htmlTemplate = templateEngine.process("order-notification", context);
        mimeMessageHelper.setText(htmlTemplate, true);

        mailSender.send(message);
    }
    public void notifyDeliveryPartnerForOrderAcceptance(RequestOrderDTO orderDTO) throws Exception {
           MimeMessage message = mailSender.createMimeMessage();
           MimeMessageHelper helper = new  MimeMessageHelper(message);
           Context context = new Context();
            context.setVariable("customerName", orderDTO.getCustomer().getName());
            context.setVariable("customerPhone", orderDTO.getCustomer().getPhoneNumber());
            context.setVariable("customerAddress", orderDTO.getCustomer().getAddress());
            context.setVariable("orderId", orderDTO.getOrder().getId());
            context.setVariable("pickupLocation", orderDTO.getDeliveryPartner().getAddress());

            String htmlTemplate = templateEngine.process("order-accept-notification", context);
            helper.setTo(orderDTO.getDeliveryPartner().getEmail());
            helper.setSubject("Order Assigned");
            helper.setText(htmlTemplate, true);

            mailSender.send(message);

    }
    public void notifyCustomerForOrderAssignment(RequestOrderDTO orderDTO) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        Context context = new Context();
        context.setVariable("deliveryPartnerName", orderDTO.getDeliveryPartner().getName());
        context.setVariable("customerName", orderDTO.getCustomer().getName());
        context.setVariable("deliveryPartnerName", orderDTO.getDeliveryPartner().getPhoneNumber());
        context.setVariable("vehicleNumber", 9314);

        String htmlTemplate = templateEngine.process("order-assigned", context);

        helper.setText(htmlTemplate, true);
        helper.setSubject("Order Assigned");
        helper.setTo(orderDTO.getCustomer().getEmail());


        mailSender.send(message);

    }
}
