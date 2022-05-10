package repository;

import model.Page;

import java.util.ArrayList;

public class PageRepositoryImpl implements PageRepository {
    private static final ArrayList<Page> pages = new ArrayList<>();

    @Override
    public void add(Page page) {
        pages.add(page);
    }

    @Override
    public ArrayList<Page> findAll() {
        return pages;
    }

    @Override
    public Page findLastPage() {
        int lastIndex = pages.size() - 1;
        return pages.get(lastIndex);
    }
}
