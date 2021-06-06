package com.email.sender.controller;

import com.email.sender.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "description", description = ". The main controller component of the API. Maps http request to specific methods")
public class EmailController {

    private EmailService emailService;

    @ApiOperation(value = "sendEmails", notes = "Send Emails")
    public ResponseEntity<String> sendEmails() {

        emailService.sendEmails();
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }


}
