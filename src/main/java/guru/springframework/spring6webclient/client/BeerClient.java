package guru.springframework.spring6webclient.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.spring6webclient.model.BeerDTO;
import java.util.Map;
import reactor.core.publisher.Flux;

public interface BeerClient {

  Flux<String> listBeer();

  Flux<Map> listBeerMap();

  Flux<JsonNode> listBeersJsonNode();

  Flux<BeerDTO> listBeerDtos();
}
