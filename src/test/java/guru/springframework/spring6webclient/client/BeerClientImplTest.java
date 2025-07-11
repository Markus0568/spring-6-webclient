package guru.springframework.spring6webclient.client;

import static org.awaitility.Awaitility.await;

import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientImplTest {

  @Autowired
  BeerClient client;

  @Test
  void listBeer() {
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    client.listBeer().subscribe(response -> {
      System.out.println(response);
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testGetMap() {
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    client.listBeerMap().subscribe(response -> {
      System.out.println(response);
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testGetBeerJson() {
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    client.listBeersJsonNode().subscribe(jsonNode -> {
      System.out.println(jsonNode.toPrettyString());
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testGetBeerDto() {
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    client.listBeerDtos().subscribe(dto -> {
      System.out.println(dto.getBeerName());
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }
}
