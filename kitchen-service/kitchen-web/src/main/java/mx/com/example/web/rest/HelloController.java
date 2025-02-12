package mx.com.example.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.example.commons.to.OrderEventTO;
import mx.com.example.commons.to.PaymentEventTO;
import mx.com.example.commons.to.TicketEventTO;
import mx.com.example.commons.to.UserTO;
import mx.com.example.services.facade.IKitchenFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("kitchen")
@Api(value="kitchen")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IKitchenFacade IKitchenFacade;

    @GetMapping(value = "/users", produces = "application/json")
    @ApiOperation(value = "Buscar Usuarios",
            notes = "Retorna todos los usuarios",
            response = UserTO.class,
            produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        List<UserTO> users = this.IKitchenFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody OrderEventTO order) {

        return new ResponseEntity(IKitchenFacade.createTicket(order), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tickets/confirm", method = RequestMethod.POST)
    public ResponseEntity confirm(@RequestBody PaymentEventTO payment) {
        IKitchenFacade.updateTicket(payment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
