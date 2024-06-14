package dev.dharam.orderservice.exceptions;



import dev.dharam.orderservice.dtos.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(CartEmptyException.class)
    public ResponseEntity handleNoProductFoundException(CartEmptyException ce){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                ce.getMessage(),
                404
        );

        return new ResponseEntity(exceptionResponseDto, HttpStatus.INSUFFICIENT_STORAGE);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity handleOrderNotFoundException(OrderNotFoundException orderNotFoundException){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                orderNotFoundException.getMessage(),
                404
        );

        return new ResponseEntity(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }





}
