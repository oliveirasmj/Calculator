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

}
