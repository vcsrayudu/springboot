package com.example.consulapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ecwid.consul.v1.kv.model.GetValue;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulapiApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ConsulapiApplication.class, args);
		ConsulClient client = new ConsulClient("localhost");
		System.out.println(client.getDatacenters().getValue().get(0));
		client.setKVBinaryValue("mykey", "myvalue".getBytes());
		System.out.println(client.getKVBinaryValue("mykey"));
		System.out.println(client.getKVValue("mykey").getValue().getDecodedValue());
		client.setKVValue("a", "b");
		System.out.println(client.getKVValue("a"));
		System.out.println(client.getKVValue("a").getValue().getDecodedValue());
		
		client.setKVValue("com.opentext.test1.test2", "somevalue");
		client.setKVValue("com.opentext.test2.test3", "somevalue2");
		client.setKVValue("com.opentext.test3.test4", "somevalue3");
		client.setKVValue("com.opentext.test4.test5", "somevalue3");
		
		Response<List<GetValue>> keyValuesResponse = client.getKVValues("com.opentext");
		keyValuesResponse.getValue().forEach(value -> System.out.println(value.getKey() + ": " + value.getDecodedValue()));
		
		NewService newService = new NewService();
		newService.setId("myserviceId");
		newService.setName("myservice");
		newService.setTags(Arrays.asList("myservice1_1", "myservice1_2"));
		newService.setPort(8080);
		client.agentServiceRegister(newService);
		
		NewService newService2 = new NewService();
		newService2.setId("myserviceId2");
		newService2.setName("myservice2");
		newService2.setTags(Arrays.asList("myservice2_1", "myservice2_2"));
		newService2.setPort(9095);
		
		NewService.Check serviceCheck = new NewService.Check();
		serviceCheck.setScript("/test1/test2/script1");
		//serviceCheck.setInterval("10s");
		serviceCheck.setTtl("60s");
		newService2.setCheck(serviceCheck);
		
		client.agentServiceRegister(newService2);
		
		HealthServicesRequest request = HealthServicesRequest.newBuilder()
				.setPassing(true)
				.setQueryParams(QueryParams.DEFAULT)
				.build();
		Response<List<HealthService>> healthyServices = client.getHealthServices("myservice", request);
		healthyServices.getValue().forEach(value -> System.out.println(value));
		
		HealthServicesRequest request2 = HealthServicesRequest.newBuilder()
				.setPassing(true)
				.setQueryParams(QueryParams.DEFAULT)
				.build();
		System.out.println("I amehere");
		Response<List<HealthService>> healthyServices2 = client.getHealthServices("myservice", request2);
		healthyServices2.getValue().forEach(value -> System.out.println(value));
		Thread.sleep(10000);
		
		
	}

}
