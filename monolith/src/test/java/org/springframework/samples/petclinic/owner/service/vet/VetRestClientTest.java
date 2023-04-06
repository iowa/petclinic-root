package org.springframework.samples.petclinic.owner.service.vet;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.monolithic.petclinic.dto.VetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VetRestClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8081));

    @Autowired
    private VetRestClient client;

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void shouldGetVetsViaRestClient() {
        wireMock.stubFor(get(urlEqualTo("/vets")).willReturn(aResponse().withHeader("Content-Type",
                        "application/json")
                .withBody(
                        "[{\"firstName\":\"James\",\"lastName\":\"Carter\",\"specialities\":[]},{\"firstName\":\"Helen\",\"lastName\":\"Leary\",\"specialities\":[\"radiology\"]},{\"firstName\":\"Linda\",\"lastName\":\"Douglas\",\"specialities\":[\"dentistry\",\"surgery\"]},{\"firstName\":\"Rafael\",\"lastName\":\"Ortega\",\"specialities\":[\"surgery\"]},{\"firstName\":\"Henry\",\"lastName\":\"Stevens\",\"specialities\":[\"radiology\"]},{\"firstName\":\"Sharon\",\"lastName\":\"Jenkins\",\"specialities\":[]}]")));

        Collection<VetDTO> result = client.allVetsDto();

        assertThat(result).hasSize(6);
    }

}