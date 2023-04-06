package org.springframework.samples.petclinic.owner.service.management;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ManagementRestClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8082));

    @Autowired
    private ManagementRestClient client;

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void listYearlyRevenue() {
        wireMock.stubFor(get(urlEqualTo("/management/revenue")).willReturn(aResponse().withHeader("Content-Type",
                        "application/json")
                .withBody(
                        "[{\"year\":2020,\"total\":1}]")));

        Collection<YearlyRevenueDTO> result = client.listYearlyRevenue();

        assertThat(result).hasSize(1);
    }
}