package com.azure.learning.functions;

import com.azure.learning.domain.Device;
import com.azure.learning.dto.DeviceDTO;
import com.azure.learning.services.impl.IdentityAzureDaoImpl;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class CreateDeviceFunction implements Function<HttpRequestMessage<DeviceDTO>, Message<Optional<String>>> {


    @Autowired
    IdentityAzureDaoImpl identityAzureDao;



    @Override
    public Message apply(HttpRequestMessage<DeviceDTO> deviceDTOHttpRequestMessage) {
        System.out.println("Inside Function");
        //return request.createResponseBuilder(HttpStatus.OK).body(uuid).header("Content-Type", "application/json").header("contenType", "application/json").build();

        String uuid =  identityAzureDao.createEntity(deviceDTOHttpRequestMessage);
        Message<String> message = MessageBuilder.withPayload(uuid).setHeader("contentType","application/json").build();
        return message;

    }
}
