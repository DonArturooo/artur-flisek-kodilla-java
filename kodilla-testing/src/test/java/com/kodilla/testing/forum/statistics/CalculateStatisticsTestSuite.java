package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalculateStatisticsTestSuite {
    @Mock
    private Statistics mockStatistics = mock(Statistics.class);
    CalculateStatistics calculateStatistics;

    @BeforeEach
    void beforeEach() {
        calculateStatistics = new CalculateStatistics();
        when(mockStatistics.usersNames()).thenReturn(mockUsers(15));
    }

    private List<String> mockUsers(int count) {
        List<String> usersNames = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            usersNames.add("user" + i);
        }

        return usersNames;
    }

    @Test
    void calculateStatisticsWhenPostsAndCommentCountIsZero() {
        calculateStatistics.calculateAdvStatistics(mockStatistics);

        assertEquals(15, calculateStatistics.getUserCount());
        assertEquals(0, calculateStatistics.getPostsCount());
        assertEquals(0, calculateStatistics.getCommentsCount());

        assertEquals(0, calculateStatistics.getAveragePosts());
        assertEquals(0, calculateStatistics.getAverageComments());
        assertEquals(0, calculateStatistics.getAverageCommentsOnPosts());
    }

    @Test
    void calculateStatisticsWhenPostsCountIs1000() {
        when(mockStatistics.postsCount()).thenReturn(1000);

        calculateStatistics.calculateAdvStatistics(mockStatistics);

        assertEquals(15, calculateStatistics.getUserCount());
        assertEquals(1000, calculateStatistics.getPostsCount());
        assertEquals(0, calculateStatistics.getCommentsCount());

        assertEquals(66, calculateStatistics.getAveragePosts());
        assertEquals(0, calculateStatistics.getAverageComments());
        assertEquals(0, calculateStatistics.getAverageCommentsOnPosts());
    }

    @Test
    void calculateStatisticsWhenUsersCountIsZero() {
        when(mockStatistics.usersNames()).thenReturn(new ArrayList<>());

        calculateStatistics.calculateAdvStatistics(mockStatistics);

        assertEquals(0, calculateStatistics.getUserCount());
        assertEquals(0, calculateStatistics.getPostsCount());
        assertEquals(0, calculateStatistics.getCommentsCount());

        assertEquals(0, calculateStatistics.getAveragePosts());
        assertEquals(0, calculateStatistics.getAverageComments());
        assertEquals(0, calculateStatistics.getAverageCommentsOnPosts());
    }

    @Test
    void calculateStatisticsWhenUsersCountIs100() {
        when(mockStatistics.usersNames()).thenReturn(new ArrayList<>(mockUsers(100)));
        when(mockStatistics.postsCount()).thenReturn(100);
        when(mockStatistics.commentsCount()).thenReturn(100);

        calculateStatistics.calculateAdvStatistics(mockStatistics);

        assertEquals(100, calculateStatistics.getUserCount());
        assertEquals(100, calculateStatistics.getPostsCount());
        assertEquals(100, calculateStatistics.getCommentsCount());

        assertEquals(1, calculateStatistics.getAveragePosts());
        assertEquals(1, calculateStatistics.getAverageComments());
        assertEquals(1, calculateStatistics.getAverageCommentsOnPosts());
    }

    @Test
    void calculateStatisticsWhenPostsCountIsBiggerThenCommentsCount() {
        when(mockStatistics.postsCount()).thenReturn(100);
        when(mockStatistics.commentsCount()).thenReturn(44);

        calculateStatistics.calculateAdvStatistics(mockStatistics);

        assertEquals(15, calculateStatistics.getUserCount());
        assertEquals(100, calculateStatistics.getPostsCount());
        assertEquals(44, calculateStatistics.getCommentsCount());

        assertEquals(6, calculateStatistics.getAveragePosts());
        assertEquals(2, calculateStatistics.getAverageComments());
        assertEquals(0, calculateStatistics.getAverageCommentsOnPosts());
    }

    @Test
    void calculateStatisticsWhenPostsCountIsLowerThenCommentsCount(){
        when(mockStatistics.postsCount()).thenReturn(100);
        when(mockStatistics.commentsCount()).thenReturn(871);

        calculateStatistics.calculateAdvStatistics(mockStatistics);

        assertEquals(15, calculateStatistics.getUserCount());
        assertEquals(100, calculateStatistics.getPostsCount());
        assertEquals(871, calculateStatistics.getCommentsCount());

        assertEquals(6, calculateStatistics.getAveragePosts());
        assertEquals(58, calculateStatistics.getAverageComments());
        assertEquals(8, calculateStatistics.getAverageCommentsOnPosts());
    }
}
