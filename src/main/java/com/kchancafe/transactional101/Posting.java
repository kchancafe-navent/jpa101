package com.kchancafe.transactional101;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "postings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_id")
    private Long id;
    @Column(name = "title")
    private String title;

    //    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cart")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "posting_id", nullable = false)
    private List<PostingPrice> prices = new ArrayList<>();

    public static Posting random() {
        Posting posting = new Posting();
        posting.setTitle(Faker.get().videoGame().title());
        return posting;
    }

    public static Posting randomWithPrice() {
        Posting random = random();
        List<PostingPrice> randomPrices = new ArrayList<>();
        randomPrices.add(PostingPrice.random());
        random.setPrices(randomPrices);
        return random;
    }

}
