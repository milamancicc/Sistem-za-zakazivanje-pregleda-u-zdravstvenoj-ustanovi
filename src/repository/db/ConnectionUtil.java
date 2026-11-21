/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author PC
 */
public class ConnectionUtil {
    private Properties properties;
    private static ConnectionUtil instance;

    public ConnectionUtil() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("db.properties"));
    }
    
    public static ConnectionUtil getInstance() throws IOException{
        if(instance == null){
            return new ConnectionUtil();
        }
        return instance;
    }
    
    public String getUrl(){
        return properties.getProperty("url");
    }
    public String getUser(){
        return properties.getProperty("user");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
    
}
