package com.java.freddie.api.definition;

import com.java.freddie.helpers.CategoryCollection;
import com.java.freddie.helpers.ObservationCollection;
import com.java.freddie.helpers.SeriesCollection;
import com.java.freddie.objects.Category;
import com.java.freddie.objects.Release;
import com.java.freddie.objects.Series;

import retrofit.http.GET;
import retrofit.http.Query;

public interface IFredApiService
{

	@GET("/series")
	Series getSeries(
			@Query("series_id") String seriesName,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);

	@GET("/series/observations")
	ObservationCollection getObservations(
			@Query("series_id") String seriesName,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);

	@GET("/category")
	Category getCategoryById(
			@Query("category_id") int categoryId,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);

	@GET("/category/children")
	CategoryCollection getCategoryChildren(
			@Query("category_id") int categoryId,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);

	@GET("/release")
	Release getReleaseById(
			@Query("release_id") int releaseId,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);

	@GET("/release/series")
	SeriesCollection getSeriesByReleaseId(
			@Query("release_id") int releaseId,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);
}
