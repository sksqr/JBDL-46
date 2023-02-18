import org.gfg.keyword.KeywordAnalyzerInterface;
import org.gfg.keyword.UniqueKeywordAnalyser;

public class SearchAPIService {

    public static void main(String[] args) {

        String keyword1 = "laptop";
        KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyser();
        keywordAnalyzer.recordKeyword(keyword1);
        System.out.println(keywordAnalyzer.getAllKeyword());

    }
}
