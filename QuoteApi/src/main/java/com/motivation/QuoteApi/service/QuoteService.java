package com.motivation.QuoteApi.service;

import com.motivation.QuoteApi.model.Quote;
import com.motivation.QuoteApi.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    // Obtenir toutes les quotes
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    // Obtenir une quote aléatoire
    public Quote getRandomQuote() {
        return quoteRepository.findRandomQuote();
    }

    // Ajouter une nouvelle quote
    public Quote addQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    // Supprimer une quote par ID
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }
}
