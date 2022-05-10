package model;

public class PageRank {
    private final Integer pageNo;
    private final Double weight;

    public PageRank(Integer pageNo, Double weight) {
        this.pageNo = pageNo;
        this.weight = weight;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Double getWeight() {
        return weight;
    }
}

