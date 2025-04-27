package ro.upb.acs.worldcuptickets.ticketservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import ro.upb.acs.worldcuptickets.ticketservice.repository.TicketRepository;

@Configuration
public class TicketRepositoryConfiguration {

    @Value("${db-service.url}")
    private String dbServiceUrl;

    @Bean("ticketServiceRestClient")
    public RestClient ticketServiceRestClient() {
        return RestClient.builder()
            .baseUrl(dbServiceUrl)
            .build();
    }

    @Bean
    public TicketRepository ticketRepository(@Qualifier("ticketServiceRestClient") RestClient restClient) {
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(TicketRepository.class);
    }
}
