package it.devlec.ProgettoProdotto.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prodotto {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    Date dataacquisto;
    Date datascadenza;
    float price;
    float gradi;

    public Prodotto() {
    }

    public Prodotto(String nome, float prezzo) {
        this.nome = nome;
        this.price = prezzo;
    }
    public Prodotto(String nome, float prezzo,float gradi) {
        this.nome = nome;
        this.price = prezzo;
        this.gradi = gradi;
    }
    public Prodotto(String nome, Date dataAcquisto, Date dataScadenza) {
        this.nome = nome;
        this.dataacquisto = dataAcquisto;
        this.datascadenza = dataScadenza;
    }
    public Prodotto(String nome, Date dataAcquisto, Date dataScadenza, float prezzo, float gradi){
            this.nome = nome;
            this.dataacquisto = dataAcquisto;
            this.datascadenza = dataScadenza;
            this.price = prezzo;
            this.gradi = gradi;
        }

        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public Date getDataacquisto() {
            return dataacquisto;
        }

        public void setDataacquisto(Date dataacquisto){
            this.dataacquisto = dataacquisto;
        }


        public Date getDatascadenza() {
            return datascadenza;
        }

        public void setDatascadenza(Date datascadenza){
            this.datascadenza = datascadenza;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price){
            this.price = price;
        }

        public float getGradi() {
            return gradi;
        }

        public void setGradi(float gradi){
            this.gradi = gradi;
        }
    }