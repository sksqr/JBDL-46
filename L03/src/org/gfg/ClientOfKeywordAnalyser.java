package org.gfg;

public class ClientOfKeywordAnalyser {
    public static void main(String[] args) {
        String keyword = "pen";
        //KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyser();
        KeywordAnalyzerInterface keywordAnalyzer = new KeywordAnalyzerWithfrequency();
        keywordAnalyzer.recordKeyword(keyword);
        keywordAnalyzer.recordKeyword("mouse");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("mouse");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("mouse");
        keywordAnalyzer.recordKeyword("tv");
        keywordAnalyzer.recordKeyword("tv");
        keywordAnalyzer.recordKeyword("keyboard");
        keywordAnalyzer.recordKeyword("pencil");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("pencil");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("keyboard");

        System.out.println(keywordAnalyzer.getAllKeyword());
        System.out.println(keywordAnalyzer.getKeywordWithFrequency());

        System.out.println(keywordAnalyzer.getTop5Keyword());

       // System.out.println(keywordAnalyzer.getTop5Keyword());

    }
}
