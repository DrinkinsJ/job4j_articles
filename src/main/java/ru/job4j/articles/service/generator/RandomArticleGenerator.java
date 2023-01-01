package ru.job4j.articles.service.generator;

import ru.job4j.articles.model.Article;
import ru.job4j.articles.model.Word;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomArticleGenerator implements ArticleGenerator {
    private List<Word> cacheWords = List.of();
    private List<String> wordsCopy = List.of();

    @Override
    public Article generate(List<Word> words) {
        if (!cacheWords.equals(words)) {
            cacheWords = List.copyOf(words);
            wordsCopy = words.stream()
                    .map(Word::getValue)
                    .collect(Collectors.toList());
        }
        Collections.shuffle(wordsCopy);
        return new Article(String.join(" ", wordsCopy));
    }
}
