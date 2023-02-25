package com.example.L07springbootmvcannotations;

import org.gfg.keyword.KeywordAnalyzerImpl;
import org.gfg.keyword.KeywordAnalyzerInterface;
import org.gfg.keyword.UniqueKeywordAnalyser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    public KeywordAnalyzerInterface uniqueKeywordAnalyser(){
        return new UniqueKeywordAnalyser();
    }

    @Bean
    @Primary
    public KeywordAnalyzerInterface keywordAnalyzerImpl(){
        return new KeywordAnalyzerImpl();
    }
}
