package guru.springframework.spring6restmvc.bootstrap;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class BootstrapData implements CommandLineRunner {

    public BootstrapData(BeerRepository beerRepository, CustomerRepository customerRepository) {
        this.beerRepository = beerRepository;
        this.customerRepository = customerRepository;
    }

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Beer beer = new Beer();
        beer.setVersion(9);
        beer.setBeerName("Zywieckie");
        beer.setBeerStyle(BeerStyle.PILSNER);
        beer.setUpc("654321");
        beer.setQuantityOnHand(100);
        beer.setPrice(new BigDecimal(12.50));
        beer.setUpdateDate(LocalDateTime.now());
        beer.setCreatedDate(LocalDateTime.now());

        Beer beer1 = new Beer();
        beer1.setVersion(8);
        beer1.setBeerName("Okocim");
        beer1.setBeerStyle(BeerStyle.LAGER);
        beer1.setUpc("54321");
        beer1.setQuantityOnHand(200);
        beer1.setPrice(new BigDecimal(10.50));
        beer1.setUpdateDate(LocalDateTime.now());
        beer1.setCreatedDate(LocalDateTime.now());

        Beer beer2 = new Beer();
        beer2.setVersion(7);
        beer2.setBeerName("Zeteckie");
        beer2.setBeerStyle(BeerStyle.ALE);
        beer2.setUpc("36832");
        beer2.setQuantityOnHand(300);
        beer2.setPrice(new BigDecimal(15.20));
        beer2.setUpdateDate(LocalDateTime.now());
        beer2.setCreatedDate(LocalDateTime.now());

        beerRepository.save(beer);
        beerRepository.save(beer1);
        beerRepository.save(beer2);

        System.out.println("Moje beer initialized");

        Customer customer = new Customer();
        //.id(UUID.randomUUID())
        customer.setName("F. Kaminski");
        customer.setVersion(99);
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdateDate(LocalDateTime.now());

        Customer customer1 = new Customer();
        //.id(UUID.randomUUID())
        customer1.setName("Jan Pinski");
        customer1.setVersion(66);
        customer1.setCreatedDate(LocalDateTime.now());
        customer1.setUpdateDate(LocalDateTime.now());

        Customer customer2 = new Customer();
        //.id(UUID.randomUUID())
        customer2.setName("Piotr Piotrowski");
        customer2.setVersion(33);
        customer2.setCreatedDate(LocalDateTime.now());
        customer2.setUpdateDate(LocalDateTime.now());

        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        System.out.println("Moje Customers initialized");
    }
}
