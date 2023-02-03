package com.nirajtailor.feignintegration;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.nirajtailor.feignintegration.Model.User;
import com.nirajtailor.feignintegration.Proxy.UserProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import wiremock.org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureWireMock(port = 8011)
public class FeignIntegrationApplicationTests {

	@Autowired
	private UserProxy userProxy;
	@Test
	public void getAllUsers() throws Exception {

		WireMock.stubFor(
				WireMock.get(WireMock.urlEqualTo("/user/getUsers"))
						.willReturn(new ResponseDefinitionBuilder()
								.withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
								.withStatus(HttpStatus.OK.value())
								.withBody(read("stubs/users.json"))));

		List<User> response = userProxy.getUsers(null, null, null);

		System.out.println(response);
	}

	private String read(String location) throws IOException {
		return IOUtils.toString(new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
	}

}
