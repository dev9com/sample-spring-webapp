package com.dynacrongroup.service;

import com.dynacrongroup.service.twitter.TwitterResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:data-config.xml", "classpath:configuration-sample-context.xml"})
public class TwitterSearchImplTest {

    @Autowired
    private TwitterSearch twitterSearch;

    @Test
    public void testSearchByName() throws Exception {
        List<TwitterResult> twitterResults = twitterSearch.searchByName("mikeensor");
        assertThat("Obviously this will fail if I don't post at least 1 twitter a week", twitterResults.size(), is(greaterThanOrEqualTo(1)));
    }

}
