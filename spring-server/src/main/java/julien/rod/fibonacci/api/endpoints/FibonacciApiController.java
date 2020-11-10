package julien.rod.fibonacci.api.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import julien.rod.fibonacci.api.util.FibonacciApi;
import julien.rod.fibonacci.model.Fibonacci;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-10T14:22:17.308Z")

@Controller
public class FibonacciApiController implements FibonacciApi {

    private static final Logger log = LoggerFactory.getLogger(FibonacciApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FibonacciApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Object> askValMax(@ApiParam(value = "" ,required=true )  @Valid @RequestBody String maxVal) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Fibonacci fib = new Fibonacci(maxVal);
            return ResponseEntity.status(HttpStatus.OK).body(fib);
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

}
