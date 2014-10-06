package com.freddie.api.definition;

import retrofit.http.GET;
import retrofit.http.Query;

import com.freddie.helpers.CategoryCollection;
import com.freddie.helpers.ObservationCollection;
import com.freddie.helpers.SeriesCollection;
import com.freddie.objects.Category;
import com.freddie.objects.Release;
import com.freddie.objects.Series;

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

	@GET("/series/observations")
	ObservationCollection getObservationsByFrequency(
			@Query("series_id") String seriesName,
			@Query("api_key") String apiKey,
			@Query("frequency") String frequency,
			@Query("file_type") String dataReturnType);

	@GET("/series/release")
	Release getReleaseBySeriesId(
			@Query("series_id") String seriesId,
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

	@GET("/category/series")
	SeriesCollection getSeriesByCategoryId(
			@Query("category_id") int categoryId,
			@Query("api_key") String apiKey,
			@Query("file_type") String dataReturnType);
}
