package it.devlec.ProgettoProdotto.configuration;

import it.devlec.ProgettoProdotto.model.Prodotto;
import it.devlec.ProgettoProdotto.repository.ProdottoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


    @Configuration
    public class InserimentoPrimoElemento {
        @Bean
        CommandLineRunner inserisciElementi(ProdottoRepository repository) {
            return args -> {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                Date dataScadenza = dateFormat.parse("07-04-2028");
                Date dataAcquisto = dateFormat.parse("02-05-2021");
                Prodotto p1 = new Prodotto("Peroni",  dataScadenza, dataAcquisto,1.10f, 4.7f);

               // log.info("nome: "+p1.getNome()+" prezzo: "+p1.getPrezzo()+" gradi: "+p1.getGradi()+" data di scadenza: "+p1.getDataScadenza()+" data di acquisto: "+p1.getDataAcquisto());

                dataScadenza = dateFormat.parse("23-04-2030");
                dataAcquisto = dateFormat.parse("01-03-2020");
                Prodotto p2 = new Prodotto("Bjorne",  dataScadenza, dataAcquisto,2.50f, 8.3f);

                dataScadenza = dateFormat.parse("29-07-2029");
                dataAcquisto = dateFormat.parse("08-02-2022");
                Prodotto p3 = new Prodotto("Ichnusa",  dataScadenza, dataAcquisto,2.00f, 5.0f);

                List<Prodotto> productList = new ArrayList<>();
                productList.add(p1);
                productList.add(p2);
                productList.add(p3);

                repository.saveAll(productList);


            };
        }
    }
    