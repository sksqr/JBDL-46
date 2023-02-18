package org.gfg.keyword;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
