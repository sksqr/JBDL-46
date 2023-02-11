package org.gfg;

import java.util.ArrayList;
import java.util.List;

public class KeywordAnalyzerImpl implements KeywordAnalyzerInterface{

    List<String> dataStore;

    public KeywordAnalyzerImpl() {
        dataStore = new ArrayList<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getAllKeyword() {
        return dataStore;
    }
}
