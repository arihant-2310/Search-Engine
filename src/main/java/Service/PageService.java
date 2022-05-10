package Service;

import model.Keyword;
import model.Page;
import repository.PageRepository;
import repository.PageRepositoryImpl;

import java.util.ArrayList;

public class PageService {
    PageRepository pageRepositoryImpl;

    public PageService() {
        this.pageRepositoryImpl = new PageRepositoryImpl();
    }

    public void addPage(ArrayList<Keyword> keywords, int pageNo) {
        Page page = new Page(pageNo);

        for (Keyword keyword : keywords) {
            page.add(keyword);
        }

        pageRepositoryImpl.add(page);
    }

    public void addNestedPage(ArrayList<Keyword> keywords, int pageNo) {
        Page parentPage = pageRepositoryImpl.findLastPage();
        Page page = new Page(pageNo);

        for (Keyword keyword : keywords) {
            page.add(keyword);
        }

        parentPage.addNestedPage(page);
    }
}
