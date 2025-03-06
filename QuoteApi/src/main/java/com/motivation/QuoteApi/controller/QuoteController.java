package com.motivation.QuoteApi.controller;

import com.motivation.QuoteApi.model.Quote;
import com.motivation.QuoteApi.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // Récupérer toutes les citations
    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    // Récupérer une citation aléatoire
    @GetMapping("/random")
    public Quote getRandomQuote() {
        // Utilisation de l'instance quoteRepository pour appeler findRandomQuote
        Quote randomQuote = quoteService.getRandomQuote(); // Appel sur l'instance
        if (randomQuote == null) {
            throw new RuntimeException("No quotes available");
        }
        return randomQuote;
    }

    // Ajouter une nouvelle citation
    @PostMapping
    public Quote addQuote(@RequestBody Quote quote) {
        return quoteService.addQuote(quote);
    }

    // Supprimer une citation par ID
    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }
}
