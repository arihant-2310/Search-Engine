package model;

import java.util.ArrayList;

public class Page {
    private final int pageNo;
    private final ArrayList<Keyword> keywords = new ArrayList<>();
    private final ArrayList<Page> nestedPages = new ArrayList<>();

    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    public void add(Keyword key) {
        keywords.add(key);
    }

    public int getPageNo() {
        return pageNo;
    }

    public ArrayList<Keyword> getKeywords() {
        return keywords;
    }

    public ArrayList<Page> getNestedPages() {
        return nestedPages;
    }

    public void addNestedPage(Page page) {
        nestedPages.add(page);
    }

    public boolean hasNextedPages() {
        return this.nestedPages.size() > 0;
    }
}
