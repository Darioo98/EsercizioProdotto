package it.devlec.ProgettoProdotto.controller;

import it.devlec.ProgettoProdotto.model.Prodotto;
import it.devlec.ProgettoProdotto.notife.ProdottoNonTrovato;
import it.devlec.ProgettoProdotto.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottoController {
    private static final Logger log =
            LoggerFactory.getLogger(ProdottoController.class);

    private ProdottoRepository repository;

    ProdottoController(ProdottoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/prodotti")
    public List<Prodotto> readAllProduct() {
        log.info("Prendo tutti i prodotti");
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public Prodotto searchProductWithID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdottoNonTrovato(id));
    }

    @PostMapping("/prodotto")
    public Prodotto insertNewProduct(@RequestBody Prodotto newProduct) {
        return repository.save(newProduct);
    }

    @PutMapping("/prodotto")
    public Prodotto updateProduct( @RequestBody Prodotto prodotto)
    {
        return repository.save(prodotto);

    }

    @DeleteMapping("/prodotto/{id}")
    void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/prodotto/ricercadataaquisto")
    public List<Prodotto> searchForDate(@RequestParam(name="dataDa") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                               Date dataDa,
                                       @RequestParam(name="dataA") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                               Date dataA){
        return repository.findByDataacquistoBetween(dataDa,dataA);
    }

    @GetMapping("/prodotto/ricercadatascadenza")
    public List<Prodotto> searchForDateOfExpiration(@RequestParam(name="dataDa") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                                              Date dataDa,
                                                      @RequestParam(name="datAa") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                                              Date dataA){
        return repository.findByDatascadenzaBetween(dataDa,dataA);
    }

    @GetMapping("/prodotto/prezzo")
    public List<Prodotto> searchForPrice(@RequestParam(name="min") float min,
                                         @RequestParam(name="max") float max){
        return repository.findByPriceBetween(min,max);
    }

    @GetMapping("/prodotto/prezzomax")
    public List<Prodotto> searchLessPrice(@RequestParam(name="max") float max){
        return repository.findByPriceLessThan(max);
    }

    //Upload documento

    @PostMapping("/caricafile")
    public String loadFile(@RequestParam("file") MultipartFile file){

        String infoFile = file.getOriginalFilename()+" "+file.getContentType();
        String conFormat =String.format("%s-%s",file.getOriginalFilename(),file.getContentType());
        log.info(infoFile);
        log.warn(conFormat);

        return conFormat;
    }





}

