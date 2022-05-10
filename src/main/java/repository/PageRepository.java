package repository;

import model.Page;

import java.util.ArrayList;

public interface PageRepository {
    void add(Page page);

    ArrayList<Page> findAll();

    Page findLastPage();
}
