package mx.com.example.services.facade;

import mx.com.example.commons.to.OrderTO;
import mx.com.example.commons.to.PaymentEventTO;
import mx.com.example.commons.to.UserTO;

import java.util.List;

public interface IOrderFacade {

    List<UserTO> getAllUsers();
    void createOrder(OrderTO order);
    void updateOrder(PaymentEventTO payment);
}
