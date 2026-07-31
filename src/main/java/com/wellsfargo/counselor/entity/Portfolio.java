package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio() {
    }

    public Portfolio(Client client, LocalDate creationDate, List<Security> securities) {
        this.client = client;
        this.creationDate = creationDate;
        this.securities = securities;
    }

    // Getters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    // Setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}