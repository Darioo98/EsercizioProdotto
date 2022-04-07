package it.devlec.ProgettoProdotto.repository;


import it.devlec.ProgettoProdotto.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    List<Prodotto> findByDataacquistoBetween(Date dataDa, Date dataA);
    List<Prodotto> findByDatascadenzaBetween(Date dataDa, Date dataA);
    List<Prodotto> findByPriceBetween(float minimo,float max);
    List<Prodotto> findByPriceLessThan(float max);

}