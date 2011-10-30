package com.dynacrongroup.web.model;

import com.dynacrongroup.service.twitter.TwitterResult;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TwitterPageModel {

    @NotNull(message = "{twitter.search.term.missing}")
    @Size(min = 1, max = 20, message = "{twitter.search.term.size}")
    private String searchTerm;

    private List<TwitterResult> results;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<TwitterResult> getResults() {
        return results;
    }

    public void setResults(List<TwitterResult> results) {
        this.results = results;
    }
}
