package org.gfg;

import org.gfg.keyword.KeywordAnalyzerInterface;
import org.gfg.keyword.NewKeywordAnalyzerImpl;
import org.gfg.keyword.UniqueKeywordAnalyser;

public class SearchService {

    public static void main(String[] args) {
        String keyword = "laptop";
        KeywordAnalyzerInterface keywordAnalyzerInterface = new NewKeywordAnalyzerImpl();
        keywordAnalyzerInterface.recordKeyword(keyword);
    }
}
