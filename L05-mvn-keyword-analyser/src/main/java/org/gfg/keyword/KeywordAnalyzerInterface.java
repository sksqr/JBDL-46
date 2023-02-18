package org.gfg.keyword;

import java.util.List;

public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);

    List<String> getAllKeyword();

    default List<KeywordCount> getKeywordWithFrequency(){
        return null;
    }

    default List<String> getTop5Keyword(){
        return null;
    }

}
