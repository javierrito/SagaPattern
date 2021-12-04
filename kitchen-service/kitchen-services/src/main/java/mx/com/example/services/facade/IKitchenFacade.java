package mx.com.example.services.facade;

import mx.com.example.commons.to.OrderEventTO;
import mx.com.example.commons.to.PaymentEventTO;
import mx.com.example.commons.to.UserTO;

import java.util.List;

public interface IKitchenFacade {

    List<UserTO> getAllUsers();

    void createTicket(OrderEventTO order);

    void updateTicket(PaymentEventTO payment);
}
