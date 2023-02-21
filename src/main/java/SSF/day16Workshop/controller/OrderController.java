package SSF.day16Workshop.controller;

import java.io.Reader;
import java.io.StringReader;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
// find out what path does the client side Accept, enter the corresponding path in RequestMapping
@RequestMapping(path="/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private Logger logger = Logger.getLogger(OrderController.class.getName());

    // application/json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postOrder(
        @RequestBody String payload) {
        
        logger.log(Level.INFO, "+++ payload: %s".formatted(payload));

        //Create a new reader to read input form client side and convert it into a json object
        Reader reader = new StringReader(payload);
        JsonReader jsonReader = Json.createReader(reader);
        JsonObject json = jsonReader.readObject();
        System.out.println(json.toString());

        //Creating a random orderId
        UUID orderId = UUID.randomUUID();

        //Build a json object to tell the client that whatever they input is what you want and at the same time 
        //return a/any response to them
        json = Json.createObjectBuilder()
                .add("orderId", orderId.toString())
                .add("message", "Your order has been confirmed!")
                .build();

        return ResponseEntity
        .status(201)
        .body(json.toString());

    }
    
}
