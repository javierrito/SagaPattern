package mx.com.example.services.facade.impl;

import mx.com.example.commons.to.PaymentEventTO;
import mx.com.example.commons.to.TicketEventTO;
import mx.com.example.commons.to.UserTO;
import mx.com.example.services.facade.IPaymentFacade;
import mx.com.example.services.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PaymentFacade implements IPaymentFacade {

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public List<UserTO> getAllUsers() {
        return this.paymentService.getUsers();
    }

    @Override
    public PaymentEventTO createPayment(TicketEventTO ticketEvent) {

        PaymentEventTO paymentEvent = new PaymentEventTO();
        paymentEvent.setDescription(ticketEvent.getDescription());
        paymentEvent.setDateTime(ticketEvent.getDateTime());
        paymentEvent.setUuid(ticketEvent.getUuid());

        if(ticketEvent.getStatus() == 1){
            //LANZAR PAGO
            paymentEvent.setComfirmCode("RF90");
            if(ticketEvent.getQuantity() > 5) {
                paymentEvent.setStatus(0);
            }else{
                paymentEvent.setStatus(1);
            }
        }else{
            paymentEvent.setStatus(0);
        }
        return paymentEvent;
        //kafkaTemplate.send("payment_events", paymentEvent);
    }
}
