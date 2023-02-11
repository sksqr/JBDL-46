package org.gfg;

import java.util.*;

public class UniqueKeywordAnalyser implements KeywordAnalyzerInterface{

    Set<String> dataStore;

    public UniqueKeywordAnalyser() {
       // dataStore = new HashSet<>();
        dataStore = new LinkedHashSet<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getAllKeyword() {
        List<String> list = new ArrayList<>();
        list.addAll(dataStore);
        return list;
    }
}
