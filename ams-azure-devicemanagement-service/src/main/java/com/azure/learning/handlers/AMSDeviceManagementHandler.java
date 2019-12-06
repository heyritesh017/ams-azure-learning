package com.azure.learning.handlers;

import com.azure.learning.dto.DeviceDTO;
import com.azure.learning.functions.CreateDeviceFunction;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootHttpRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@EnableAutoConfiguration
@Component
@ComponentScan(basePackages = {"com.azure.learning"})
public class AMSDeviceManagementHandler extends AzureSpringBootHttpRequestHandler{

    private static final Logger logger = LogManager.getLogger(AMSDeviceManagementHandler.class);


    @FunctionName("createDeviceFunction")
    HttpResponseMessage createUserDevice(@HttpTrigger(name="req", methods = {
            HttpMethod.POST},authLevel = AuthorizationLevel.ANONYMOUS, route = "create/device")HttpRequestMessage<DeviceDTO> requestMessage , ExecutionContext executionContext) {

        logger.info("Info log : create executed..");

        return handleRequest(requestMessage, executionContext);
        }

    @Bean
    public CreateDeviceFunction createDeviceFunction() {
        return new CreateDeviceFunction();
    }

}


