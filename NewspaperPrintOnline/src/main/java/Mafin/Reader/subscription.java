package Mafin.Reader;

import java.io.Serializable;

public class subscription  implements Serializable {
    private String terms,duration;
    private Integer cost;

    public subscription(Integer cost, String terms, String duration) {
        this.cost = cost;
        this.terms = terms;
        this.duration = duration;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
