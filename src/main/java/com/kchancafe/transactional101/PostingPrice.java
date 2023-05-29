package com.kchancafe.transactional101;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "posting_prices")
@Getter
@Setter
@NoArgsConstructor
//@ToString(exclude = "posting")
@ToString
public class PostingPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_price_id")
    private Long id;
    @Column(name = "posting_id", insertable = false, updatable = false)
    private Long postingId;
    @Column(name = "price")
    private Integer price;
    @Column(name = "operation_type_id")
    private Integer operationTypeId;

    //    @ManyToOne
//    @JoinColumn(name = "cart_id", nullable = false, updatable = false, insertable = false)
//    private Cart cart;

    public static PostingPrice random() {
        PostingPrice postingPrice = new PostingPrice();
        postingPrice.setPrice(ThreadLocalRandom.current().nextInt(1000, 100000));
        postingPrice.setOperationTypeId(ThreadLocalRandom.current().nextInt(1, 4));
        return postingPrice;
    }

}
