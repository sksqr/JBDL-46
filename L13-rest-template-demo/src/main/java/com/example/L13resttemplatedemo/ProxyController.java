package com.example.L13resttemplatedemo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy")
public class ProxyController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/blog/{id}")
    ResponseEntity<JsonNode> getBlog(@PathVariable Long id){
        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/job/{keyword}")
    ResponseEntity<JsonNode> getBlog(@PathVariable String keyword){
        String url = "https://www.naukrigulf.com/spapi/jobapi/search?Experience=&Limit=3&Keywords="+keyword;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("appid","205");
        httpHeaders.set("systemid","1112");
        httpHeaders.set("user-agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36");
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<JsonNode> responseEntity= restTemplate.exchange(url, HttpMethod.GET, httpEntity, JsonNode.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
}
