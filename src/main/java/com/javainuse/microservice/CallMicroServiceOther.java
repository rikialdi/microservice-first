package com.javainuse.microservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CallMicroServiceOther {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void callServiceEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String url = "http://localhost:8082/consumer/message";
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        System.out.println("response dari service 1  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

//    @Test
//    public void eskternalProvinsi() throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
////        String request ="";
////        // request Body
////        HttpEntity<String> entity = new HttpEntity<String>(request, headers);
//        String url = "https://dev.farizdotid.com/api/daerahindonesia/provinsi";
//        ResponseEntity<JsonNode> exchange = restTemplate.exchange(url, HttpMethod.GET, null, JsonNode.class);
//
//
//        String data = String.valueOf(exchange.getBody());
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JsonNode jsonNode = objectMapper.readTree(data);
//        System.out.println("res1=" + jsonNode.get("provinsi"));
//
//        System.out.println("res2=" + exchange.getBody());
//
//
////        System.out.println("response  =" + exchange.getBody());
////        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//    }
//
//    @Test
//    public void insertSupplier() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        String bodyTesting = "{\n" +
//                "    \"nama\":\"supplier 2\",\n" +
//                "    \"hp\":\"098765462\",\n" +
//                "    \"alamat\":\"jl sudirman2\"\n" +
//                "}";
//        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
//
//        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9091/api/v1/binar/supplier/save", HttpMethod.POST, entity, String.class);
//
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//        System.out.println("response  =" + exchange.getBody());
//    }
//
//    @Test
//    public void insertSuppliermap() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        Map bodyTesting = new HashMap();
//        bodyTesting.put("nama", "nama");
//        bodyTesting.put("hp", "445654654");
//        bodyTesting.put("alamat", "alamat53534");
//        HttpEntity<Map> entity = new HttpEntity<Map>(bodyTesting, headers);
//
//        ResponseEntity<Map> exchange = restTemplate.exchange("http://localhost:9091/api/v1/binar/supplier/save", HttpMethod.POST, entity, Map.class);
//
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//        System.out.println("response  =" + exchange.getBody());
//    }
//
//    @Test
//    public void listSupplier() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<Object, Object> map = new LinkedMultiValueMap<>();
//        map.add("page", "0");
//        map.add("size", "10");
//
//        HttpEntity<MultiValueMap<Object, Object>> request = new HttpEntity<MultiValueMap<Object, Object>>(map, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange("http://localhost:9091/api/v1/binar/supplier/list", HttpMethod.GET, request, String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        System.out.println("response  =" + response.getBody());
//    }


}

