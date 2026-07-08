package com.example;

import java.util.List;
import java.util.Map;

public interface ExternalApi {
    String getData();
    int getStatusCode();
    void updateData(String data);
    
    void saveUser(String username, String password);
    String fetchById(int id);
    void deleteRecord(long recordId);
    
    void processUser(User user);
    void updateUser(int userId, String name, String email);
    String findUser(String firstName, String lastName, int age);
    void saveBatch(List<String> items);
    void logEvent(String eventType, Map<String, Object> metadata);
}
