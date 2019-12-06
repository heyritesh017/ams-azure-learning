package com.azure.learning.services.impl;

import com.azure.learning.domain.Device;
import com.azure.learning.dto.DeviceDTO;
import com.azure.learning.services.IdentityAzureDao;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Optional;
import java.util.UUID;


@Configuration
@PropertySource("classpath:cosmosdb.properties")
public class IdentityAzureDaoImpl implements IdentityAzureDao {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(IdentityAzureDaoImpl.class);

    final private String PARTITION_KEY = "TEST-RITESH";
    public static final String TABLE_NAME = "ritesh-table";
    final String CLIENT_ID = "clientid";
    final String SESSION_ID = "session";

    public   static CloudStorageAccount cloudStorageAccount = null;
    public   static CloudTableClient cloudTableClient = null;
    public   static CloudTable cloudTable = null;
    public   static String OEM = null;


    @Value("${connection}")
    private static String connection;


    static {

        logger.info("Loading Connection String .. " + System.getenv("ConnectionString"));

        try {
            cloudStorageAccount = CloudStorageAccount.parse(connection);
            cloudTableClient = cloudStorageAccount.createCloudTableClient();
            cloudTable = cloudTableClient.getTableReference(TABLE_NAME);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (StorageException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Optional<Device> getEntity(String rowkey) {
        return Optional.empty();
    }

    @Override
    public String createEntity(HttpRequestMessage<DeviceDTO> deviceDTO) {
        String uuid = UUID.randomUUID().toString();
        Device device = new Device();
        try {
            BeanUtils.copyProperties(device, deviceDTO);
            device.setClientid(uuid);
            TableOperation createDevice = TableOperation.insert(device);
            try {
                cloudTable.execute(createDevice);
                return uuid;
            } catch (StorageException e) {
                e.printStackTrace();
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //TableOperation createEntity = TableOperation.insertOrReplace((AMSIdentity)entity);


        return "";

    }

    @Override
    public String createEntityUuid(DeviceDTO entity) {
        return null;
    }

    @Override
    public void updateEntity(DeviceDTO entity) {

    }

    @Override
    public void deleteEntity(String name) {

    }

    @Override
    public Optional<Device> getEntity(String partitionKey, String rowKey) {
        return Optional.empty();
    }

    @Override
    public Optional<Device> findEntity(DeviceDTO key) {
        return Optional.empty();
    }

    @Override
    public Iterable<Device> findAll() {
        return null;
    }

    @Override
    public Optional<Device> getEntityByClientId(String clientId) {
        return Optional.empty();
    }

    @Override
    public Optional<Device> getEntityBySessionId(String sessionId) {
        return Optional.empty();
    }

    @Override
    public Optional<Device> getEntityBySubjectId(String clientId) {
        return Optional.empty();
    }

    @Override
    public String createToken(String subjectId) {
        return null;
    }

    @Override
    public void updateLastLogin(DeviceDTO newitem) {

    }

    Device toCosmosDBAccount(DeviceDTO deviceDTO){
        Device device = new Device();
        return device;

    }
}
