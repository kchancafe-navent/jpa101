package com.kchancafe.transactional101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostingService {

    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private PostingPriceRepository postingPriceRepository;

    public Posting create() {
        return postingRepository.save(Posting.random());
    }

    public Posting createWithPrice() {
        return postingRepository.save(Posting.randomWithPrice());
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
