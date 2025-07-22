/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 *
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.examples;

import java.io.File;

import cs2725.api.df.ColumnAggregate;
import cs2725.api.df.DataFrame;
import cs2725.api.df.Series;
import cs2725.impl.ArrayList;
import cs2725.impl.df.DataFrameImpl;

/**
 * This class must be used to demonstrate the completed DataFrame project.
 */
public class DataFrameDemo {

    public static void main(String[] args) {
        // Load data from a CSV file. After loading all columns are of type String.
        DataFrame dataFrame = new DataFrameImpl()
                .readCsv("resources" + File.separator + "movies.csv");

        // Convert the String columns to their appropriate types as needed.
        dataFrame = dataFrame.mapValues("Month", Integer::parseInt, String.class, Integer.class)
                .mapValues("Day", Integer::parseInt, String.class, Integer.class)
                .mapValues("Year", Integer::parseInt, String.class, Integer.class)
                .mapValues("Rating", Integer::parseInt, String.class, Integer.class);

        // --- Begin your demo implementation ---

        // 1. Group by movie title and compute average rating using an inline aggregator
        ColumnAggregate<Integer, Double> avgRatingAgg = new ColumnAggregate<>(
                "Rating", "avg_rating",
                series -> {
                    int sum = 0;
                    int count = 0;
                    for (int i = 0; i < series.size(); i++) {
                        Integer val = series.get(i);
                        if (val != null) {
                            sum += val;
                            count++;
                        }
                    }
                    return count == 0 ? 0.0 : (double) sum / count;
                },
                Integer.class,
                Double.class
        );

        ArrayList<ColumnAggregate<?, ?>> aggregates = new ArrayList<>();
        aggregates.insertItem(avgRatingAgg);

        // Group, aggregate, sort, and take top 10 movies
        DataFrame topMovies = dataFrame
                .groupBy("Title")
                .aggregate(aggregates)
                .sortBy("avg_rating", java.util.Comparator.reverseOrder(), Double.class)
                .rows(0, 10);

        System.out.println("Top 10 Highest Rated Movies:");
        System.out.println(topMovies);

        // 2. Filter original DataFrame to only include those top 10 movies
        Series<String> topTitles = topMovies.getColumn("Title", String.class);
        Series<String> allTitles = dataFrame.getColumn("Title", String.class);

        Series<Boolean> mask = allTitles.mapValues(title -> {
            for (int i = 0; i < topTitles.size(); i++) {
                if (title.equals(topTitles.get(i))) return true;
            }
            return false;
        });

        DataFrame filtered = dataFrame.selectByMask(mask);

        // 3. Combine movie title and age group into a single key
        Series<String> ageCol = filtered.getColumn("Age", String.class);
        Series<String> movieCol = filtered.getColumn("Title", String.class);

        Series<String> combinedKey = movieCol.combineWith(ageCol,
                (movie, age) -> movie + " (" + age + ")");
        filtered = filtered.addColumn("movie+age", String.class, combinedKey);

        // 4. Group by the combined column and compute average rating by age group
        ColumnAggregate<Integer, Double> avgByAgeAgg = new ColumnAggregate<>(
                "Rating", "avg_rating",
                series -> {
                    int sum = 0;
                    int count = 0;
                    for (int i = 0; i < series.size(); i++) {
                        Integer val = series.get(i);
                        if (val != null) {
                            sum += val;
                            count++;
                        }
                    }
                    return count == 0 ? 0.0 : (double) sum / count;
                },
                Integer.class,
                Double.class
        );

        ArrayList<ColumnAggregate<?, ?>> byAgeAggs = new ArrayList<>();
        byAgeAggs.insertItem(avgByAgeAgg);

        DataFrame byAge = filtered
                .groupBy("movie+age")
                .aggregate(byAgeAggs);

        System.out.println("Average Rating by Age Group for Top 10 Movies:");
        System.out.println(byAge);

        // --- End your demo implementation ---
    }
}
