package com.kchancafe.transactional101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Service
public class PostingService {

    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private PostingPriceRepository postingPriceRepository;

    public Posting getById(Long id) {
        return postingRepository.findById(id).get();
    }

    public Posting create() {
        return postingRepository.save(Posting.random());
    }

    public Posting createWithPrice() {
        return postingRepository.save(Posting.randomWithPrice());
    }

    public Posting createWithMultiplePrices(Integer quantity) {
        Posting random = Posting.random();
        List<PostingPrice> postingPrices = Stream.generate(() -> PostingPrice.random())
                .limit(quantity).collect(Collectors.toList());
        random.setPrices(postingPrices);
        return postingRepository.save(random);
    }

    public Posting update(Posting posting) {
        return postingRepository.save(posting);
    }

    public void delete(Long id) {
        postingRepository.deleteById(id);
    }

    public void delete(Posting posting) {
        postingRepository.delete(posting);
    }

}
