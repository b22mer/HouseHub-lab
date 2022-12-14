package com.ssafy.home.aop;

import com.ssafy.home.common.dto.ResponseDTO;
import io.jsonwebtoken.JwtException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLSyntaxErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseDTO> NullPointerException(NullPointerException n) {
        n.printStackTrace();
        ResponseDTO res = new ResponseDTO();
        res.setErrMsg("null pointer");
        res.setStatus("fail");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<ResponseDTO> SqlSyntaxErrorException(SQLSyntaxErrorException s) {
        System.out.println("sql syntax error");
        ResponseDTO res = new ResponseDTO();
        res.setStatus("fail");
        res.setErrMsg("sql syntax error");
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<ResponseDTO> BadSqlGrammarException(BadSqlGrammarException b) {
        b.printStackTrace();
        ResponseDTO res = new ResponseDTO();
        res.setErrMsg("Bad sql grammar");
        res.setStatusCode(404);
        res.setStatus("fail");
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO> RuntimeException(RuntimeException r) {
        System.out.println("run time exception");
        ResponseDTO res = new ResponseDTO();
        res.setStatusCode(404);
        res.setErrMsg("Run time exception");
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO> NotFoundException(NotFoundException n) {
        ResponseDTO res = new ResponseDTO();
        res.setErrMsg("Not found exception");
        res.setStatusCode(404);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> Exception(Exception e) {
        System.out.println("Exception");
        ResponseDTO res = new ResponseDTO();
        res.setErrMsg("Exception");
        res.setStatusCode(404);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ResponseDTO> JWTException(JwtException j) {
        ResponseDTO res = new ResponseDTO();
        res.setErrMsg(j.getMessage());
        res.setStatusCode(404);
        res.setStatus("fail");
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }



}
