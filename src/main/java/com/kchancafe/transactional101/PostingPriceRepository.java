package com.kchancafe.transactional101;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingPriceRepository extends CrudRepository<PostingPrice, Long> {
}
