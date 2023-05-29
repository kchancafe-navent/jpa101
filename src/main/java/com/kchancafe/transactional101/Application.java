package com.kchancafe.transactional101;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PostingService postingService;
    @Autowired
    private PostingPriceRepository postingPriceRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Posting postingWithPrice = postingService.createWithPrice();
        //Posting posting = postingService.getById(4L);
//        posting.getPrices().add(PostingPrice.random());
//        postingService.update(posting);
        Posting posting = postingService.createWithMultiplePrices(3);
        LOGGER.info("POSTING: {}", posting);
        System.exit(1);
    }



}
