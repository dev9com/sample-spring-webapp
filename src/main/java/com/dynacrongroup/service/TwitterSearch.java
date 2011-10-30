package com.dynacrongroup.service;

import com.dynacrongroup.service.twitter.TwitterResult;

import java.util.List;

public interface TwitterSearch {

    List<TwitterResult> searchByName(String searchTerm);

}
