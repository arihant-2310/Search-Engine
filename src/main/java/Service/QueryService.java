package Service;

import model.Keyword;
import model.Page;
import model.PageRank;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class QueryService {

    public ArrayList<PageRank> execute(ArrayList<Keyword> queryKeywords, ArrayList<Page> pages) {
        ArrayList<PageRank> pageRanks = getPageRanks(queryKeywords, pages);
        sortPageRanks(pageRanks);
        return (ArrayList<PageRank>) pageRanks.stream().limit(5).collect(Collectors.toList());
    }

    private void sortPageRanks(ArrayList<PageRank> pageRanks) {
        pageRanks.sort((p1, p2) -> p2.getWeight().compareTo(p1.getWeight()));
    }

    private ArrayList<PageRank> getPageRanks(ArrayList<Keyword> queryKeywords, ArrayList<Page> pages) {
        ArrayList<PageRank> pageRanks = new ArrayList<>();

        for (Page page : pages) {
            double totalPageStrength;
            int nestedPagesStrength = 0;
            int pageStrength = getPageStrength(page, queryKeywords);

            if (page.hasNextedPages()) {
                for (Page nestedPage : page.getNestedPages()) {
                    nestedPagesStrength += getPageStrength(nestedPage, queryKeywords);
                }
            }

            totalPageStrength = pageStrength + 0.1 * nestedPagesStrength;

            if (totalPageStrength > 0) {
                PageRank pageRank = new PageRank(page.getPageNo(), totalPageStrength);
                pageRanks.add(pageRank);
            }
        }

        return pageRanks;
    }

    private int getPageStrength(Page page, ArrayList<Keyword> queryKeywords) {
        int strength = 0;

        for (Keyword queryKeyword : queryKeywords) {
            for (Keyword pageKeyword : page.getKeywords()) {
                if (Objects.equals(pageKeyword.getKey(), queryKeyword.getKey())) {
                    strength += pageKeyword.getWeight() * queryKeyword.getWeight();
                }
            }
        }

        return strength;
    }
}
