package com.azure.learning.services;

import com.azure.learning.domain.Device;
import com.azure.learning.dto.DeviceDTO;
import com.microsoft.azure.functions.HttpRequestMessage;

import java.util.Optional;

public interface IdentityAzureDao {

    Optional<Device> getEntity(String rowkey);

    String createEntity(HttpRequestMessage<DeviceDTO> device);

    String  createEntityUuid(DeviceDTO device);

    void updateEntity(DeviceDTO device);

    void deleteEntity(String name);

    Optional<Device> getEntity(String partitionKey, String rowKey);

    Optional<Device> findEntity(DeviceDTO device);

    Iterable<Device> findAll();

    Optional<Device> getEntityByClientId(String clientId);

    Optional<Device> getEntityBySessionId(String sessionId);

    Optional<Device> getEntityBySubjectId(String clientId);

    String createToken(String subjectId);

    void updateLastLogin(DeviceDTO device);
}
