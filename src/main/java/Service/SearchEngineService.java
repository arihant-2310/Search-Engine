package Service;

import model.Keyword;
import model.PageRank;
import repository.PageRepository;
import repository.PageRepositoryImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngineService {
    private final PageRepository pageRepositoryImpl;
    private final PageService pageService;
    private final QueryService queryService;

    String PAGE_IDENTIFIER = "P";
    String QUERY_IDENTIFIER = "Q";
    String NESTED_PAGE_IDENTIFIER = "PP";
    int MAX_NO_OF_KEYWORDS = 8;
    int queryNo = 0;
    int pageNo = 0;

    public SearchEngineService() {
        pageRepositoryImpl = new PageRepositoryImpl();
        pageService = new PageService();
        queryService = new QueryService();
    }

    public void process(ArrayList<String> commands) {
        for (String command : commands) {
            String identifier = command.split(" ")[0];
            ArrayList<Keyword> keywords = extractKeywords(command);

            if (identifier.equals(PAGE_IDENTIFIER)) {
                pageService.addPage(keywords, ++pageNo);
            } else if (identifier.equals(NESTED_PAGE_IDENTIFIER)) {
                pageService.addNestedPage(keywords, pageNo);
            } else if (identifier.equals(QUERY_IDENTIFIER)) {
                queryNo++;
                ArrayList<PageRank> pageRanks = queryService.execute(keywords, pageRepositoryImpl.findAll());
                display(pageRanks);
            } else {
                System.out.println("Invalid command, can't perform the operation!!");
            }
        }
    }

    private void display(ArrayList<PageRank> pageRanks) {
        System.out.print("Q" + queryNo + ": ");
        for (PageRank pageRank : pageRanks) {
            System.out.print("P" + pageRank.getPageNo() + " ");
        }
        System.out.println();
    }

    private ArrayList<Keyword> extractKeywords(String command) {
        int noOfKeywords = command.split(" ").length;
        ArrayList<String> keywords = new ArrayList<>(Arrays.asList(command.split(" ")).subList(1, noOfKeywords));
        ArrayList<Keyword> result = new ArrayList<>();

        for (int i = 0; i < keywords.size(); i++) {
            String key = keywords.get(i);
            int keywordWeight = MAX_NO_OF_KEYWORDS - i;

            Keyword keyword = new Keyword(key, keywordWeight);
            result.add(keyword);
        }

        return result;
    }
}
