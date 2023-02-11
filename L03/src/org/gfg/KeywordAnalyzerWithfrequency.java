package org.gfg;

import java.util.*;

public class KeywordAnalyzerWithfrequency implements KeywordAnalyzerInterface {

    private Map<String,KeywordCount> dataStore;

    private Queue<KeywordCount> keywordCountQueue;
// keyword, frequency
    public KeywordAnalyzerWithfrequency() {
//        dataStore = new HashMap<>();
        dataStore = new LinkedHashMap<>();
//        keywordCountQueue = new PriorityQueue<>((keywordCount, t1) -> keywordCount.getKeyword().compareTo(t1.getKeyword()));//        keywordCountQueue = new PriorityQueue<>();
        keywordCountQueue = new PriorityQueue<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        KeywordCount keywordCount = dataStore.get(keyword);
        if(keywordCount == null){
            dataStore.put(keyword,new KeywordCount(keyword,1));
        }
        else{
            keywordCount.setCount(keywordCount.getCount()+1);
        }
        keywordCountQueue.remove(dataStore.get(keyword));
        keywordCountQueue.add(dataStore.get(keyword));
    }

    @Override
    public List<String> getAllKeyword() {
        List<String> list = new ArrayList<>();
        list.addAll(dataStore.keySet());
        return list;
    }

    @Override
    public List<KeywordCount> getKeywordWithFrequency() {
        List<KeywordCount> list = new ArrayList<>();
        list.addAll(dataStore.values());
        return list;
    }

    public List<String> getTop5Keyword(){
        List<String> list = new ArrayList<>();
        for (int i=0; i<5 && keywordCountQueue.size()>0; i++){
            list.add(keywordCountQueue.poll().getKeyword());
        }
        return list;
    }
}
