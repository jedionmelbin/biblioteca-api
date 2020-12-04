package com.ixcorp.app.api.rabitmq.consumer;

import com.ixcorp.app.api.controllers.PrestamoController;
import com.ixcorp.app.api.dto.PrestamoStatus;
import com.ixcorp.app.api.rabitmq.ConfigureRabbitMq;
import com.ixcorp.app.api.service.PrestamoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrestamoConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);

    @Autowired
    private PrestamoService prestamoService;

    @RabbitListener(queues = ConfigureRabbitMq.QUEUE)
    public void consumerMessageFromQueue(PrestamoStatus prestamoStatus) {
        logger.debug("Create message que");
        try {

            prestamoService.createPrestamo(prestamoStatus.getPrestamos());
            System.out.println("Message received from queues" + prestamoStatus.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage(),"Error en servicio de mensajeria");
            throw ex;
        }

    }
}
