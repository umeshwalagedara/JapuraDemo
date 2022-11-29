package com.example.client.student.controller;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/testuser")
public class TestUserController {


  @Autowired
  private EurekaClient eurekaClient;

  @GetMapping("/{id}")
  public String testUser(@PathVariable int id){
    Application application = eurekaClient.getApplication("user-service");
    InstanceInfo instanceInfo = application.getInstances().get(0);
    String hostName = instanceInfo.getHostName();
    int port = instanceInfo.getPort();

    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "http://" + hostName + ":" + port + "/user/"+ id;
    ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl + "/", String.class);
    return response.getBody();

  }

}
