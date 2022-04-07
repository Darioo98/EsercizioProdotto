package it.devlec.ProgettoProdotto.notife;

public class ProdottoNonTrovato extends RuntimeException {
    public ProdottoNonTrovato(Long id){
        super("Eccezione : Prodotto non trovato " + id);
    }

}

