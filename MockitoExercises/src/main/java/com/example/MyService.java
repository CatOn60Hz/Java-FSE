package com.example;

import java.util.List;
import java.util.Map;

public class MyService {
    private ExternalApi externalApi;
    
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    public String fetchData() {
        return externalApi.getData();
    }
    
    public int checkStatus() {
        return externalApi.getStatusCode();
    }
    
    public void saveData(String data) {
        externalApi.updateData(data);
    }
    
    public void registerUser(String username, String password) {
        externalApi.saveUser(username, password);
    }
    
    public String getUserName(int id) {
        return externalApi.fetchById(id);
    }
    
    public void removeRecord(long id) {
        externalApi.deleteRecord(id);
    }

    public void handleUser(User user) {
        externalApi.processUser(user);
    }
    
    public void modifyUser(int id, String name, String email) {
        externalApi.updateUser(id, name, email);
    }
    
    public String searchPerson(String firstName, String lastName, int age) {
        return externalApi.findUser(firstName, lastName, age);
    }
    
    public void storeItems(List<String> items) {
        externalApi.saveBatch(items);
    }
    
    public void recordEvent(String event, Map<String, Object> metadata) {
        externalApi.logEvent(event, metadata);
    }
}
