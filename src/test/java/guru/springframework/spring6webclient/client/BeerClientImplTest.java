package guru.springframework.spring6webclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientImplTest {

  @Autowired
  BeerClient client;

  @Test
  void listBeer() {
    client.listBeer().subscribe(response -> {
      System.out.println(response);
    });

    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
