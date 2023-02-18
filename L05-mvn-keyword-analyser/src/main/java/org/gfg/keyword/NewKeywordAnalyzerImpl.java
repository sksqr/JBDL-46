package org.gfg.keyword;

import java.util.List;

public class NewKeywordAnalyzerImpl implements KeywordAnalyzerInterface{
    @Override
    public void recordKeyword(String keyword) {

    }

    @Override
    public List<String> getAllKeyword() {
        return null;
    }

    @Override
    public List<KeywordCount> getKeywordWithFrequency() {
        return KeywordAnalyzerInterface.super.getKeywordWithFrequency();
    }

    @Override
    public List<String> getTop5Keyword() {
        return KeywordAnalyzerInterface.super.getTop5Keyword();
    }
}
