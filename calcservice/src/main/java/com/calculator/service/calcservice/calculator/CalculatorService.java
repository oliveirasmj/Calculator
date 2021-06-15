package com.calculator.service.calcservice.calculator;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorService {

    Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    @GetMapping("/sum")
    public ResponseEntity sum(@RequestParam("a") double a, @RequestParam("b") double b) {
        logger.info("Entering sum endpoint");

        //Generate requestKey
        String requestKey = UUID.randomUUID().toString();
        MDC.put("RequestKey", requestKey);
        logger.info("RequestKey: " + requestKey);

        try {
            Gson gson = new Gson();
            //double sum = a + b;
            BigDecimal sum = new BigDecimal(a + b, MathContext.DECIMAL64); //arbitraryprecision signed decimal numbers
            String jsonResp = gson.toJson("result:" + sum);
            logger.info("Returning sum -> " + a + "+" + b + "=" + sum);
            return ResponseEntity.ok().header("id", requestKey).body(jsonResp);
        } catch (Exception e){
            logger.info("Unable to sum");
            logger.warn("Unable to sum: " + e.getMessage());
            return ResponseEntity.internalServerError().header("id", requestKey).body("ERROR");
        }
    }

    @GetMapping("/sub")
    public ResponseEntity sub(@RequestParam("a") double a, @RequestParam("b") double b) {
        logger.info("Entering sub endpoint");

        //Generate requestKey
        String requestKey = UUID.randomUUID().toString();
        MDC.put("RequestKey", requestKey);
        logger.info("RequestKey: " + requestKey);

        try {
            Gson gson = new Gson();
            //double sub = a - b;
            BigDecimal sub = new BigDecimal(a - b, MathContext.DECIMAL64); //arbitraryprecision signed decimal numbers
            String jsonResp = gson.toJson("result:" + sub);
            logger.info("Returning sub -> " + a + "-" + b + "=" + sub);
            return ResponseEntity.ok().header("id", requestKey).body(jsonResp);
        } catch (Exception e) {
            logger.info("Unable to sub");
            logger.warn("Unable to sub: " + e.getMessage());
            return ResponseEntity.internalServerError().header("id", requestKey).body("ERROR");
        }
    }

    @GetMapping("/mul")
    public ResponseEntity mul(@RequestParam("a") double a, @RequestParam("b") double b) {
        logger.info("Entering mul endpoint");

        //Generate requestKey
        String requestKey = UUID.randomUUID().toString();
        MDC.put("RequestKey", requestKey);
        logger.info("RequestKey: " + requestKey);

        try {
            Gson gson = new Gson();
            //double mul = a * b;
            BigDecimal mul = new BigDecimal(a * b, MathContext.DECIMAL64); //arbitraryprecision signed decimal numbers
            String jsonResp = gson.toJson("result:" + mul);
            logger.info("Returning mul -> " + a + "*" + b + "=" + mul);
            return ResponseEntity.ok().header("id", requestKey).body(jsonResp);
        } catch (Exception e){
            logger.info("Unable to mul");
            logger.warn("Unable to mul: " + e.getMessage());
            return ResponseEntity.internalServerError().header("id", requestKey).body("ERROR");
        }
    }

    @GetMapping("/div")
    public ResponseEntity div(@RequestParam("a") double a, @RequestParam("b") double b) {
        logger.info("Entering div endpoint");

        //Generate requestKey
        String requestKey = UUID.randomUUID().toString();
        MDC.put("RequestKey", requestKey);
        logger.info("RequestKey: " + requestKey);

        try{
            Gson gson = new Gson();
            //double div = a / b;
            BigDecimal div = new BigDecimal(a/b, MathContext.DECIMAL64); //arbitraryprecision signed decimal numbers
            String jsonResp = gson.toJson("result:" + div);
            logger.info("Returning div -> " + a + "/" + b + "=" + div);
            return ResponseEntity.ok().header("id", requestKey).body(jsonResp);
        } catch (Exception e){
            logger.info("Unable to div");
            logger.warn("Unable to div: " + e.getMessage());
            return ResponseEntity.internalServerError().header("id", requestKey).body("ERROR");
        }
    }
}
