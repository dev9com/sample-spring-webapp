package com.dev9.service;

import com.dev9.service.twitter.TwitterResult;

import java.util.List;

public interface TwitterSearch {

    List<TwitterResult> searchByName(String searchTerm);

}
