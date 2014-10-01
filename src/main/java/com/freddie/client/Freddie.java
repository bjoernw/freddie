package com.freddie.client;

import com.google.common.util.concurrent.RateLimiter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.freddie.api.definition.IFredApiService;
import com.freddie.deserializers.*;
import com.freddie.helpers.CategoryCollection;
import com.freddie.helpers.ObservationCollection;
import com.freddie.helpers.SeriesCollection;
import com.freddie.objects.Category;
import com.freddie.objects.Release;
import com.freddie.objects.Series;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.GsonConverter;
import javax.annotation.Nullable;
import java.util.List;

/**
 * @author bweidlich
 * 
 */
public class Freddie
{
	private static Log log = LogFactory.getLog(Freddie.class);
	private String apiKey;
	private String endPoint;
	final static String RETURNTYPE = "json";
	private static Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.setDateFormat("yyyy-MM-dd")
			.registerTypeAdapter(ObservationCollection.class, new ObservationCollectionDeserializer())
			.registerTypeAdapter(Series.class, new SeriesDeserializer())
			.registerTypeAdapter(Category.class, new CategoryDeserializer())
			.registerTypeAdapter(CategoryCollection.class, new CategoryCollectionDeserializer())
			.registerTypeAdapter(Release.class, new ReleaseDeserializer()).create();

	private static RestAdapter restAdapter = null;
	private static IFredApiService service = null;
	private final RateLimiter rateLimiter;

	public Freddie(String apiKey)
	{
		this(apiKey, "http://api.stlouisfed.org/fred/");
	}

	public Freddie(String apiKey, @Nullable String optEndPoint)
	{
		this(apiKey,optEndPoint, 2);
	}

	public Freddie(String apiKey, @Nullable String optEndPoint, int requestsPerSecond)
	{
		rateLimiter = RateLimiter.create(requestsPerSecond);
		this.apiKey = apiKey;
		if (optEndPoint != null && !optEndPoint.isEmpty())
			this.endPoint = optEndPoint;

		restAdapter =
				new RestAdapter.Builder().setEndpoint(endPoint).setLogLevel(LogLevel.NONE).setConverter(new GsonConverter(gson))
						.build();
		service = restAdapter.create(IFredApiService.class);
	}


	/**
	 * @param series Series for which to fetch observations
	 * @return same Series object
	 */
	public Series addObservations(Series series) throws Exception
	{
		if (series.getData() != null && !series.getData().isEmpty())
			return series;

		ObservationCollection observations;
		try {
			observations = service.getObservations(series.getId(), apiKey, RETURNTYPE);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		
		series.setData(observations.getObservations());
		return series;
	}


	/**
	 * @param seriesId
	 * @param withData whether Series object should contain observations. Be mindful of API
	 *        limitations.
	 * @return a Series object
	 * @throws Exception
	 */
	public Series getSeriesById(String seriesId, boolean withData) throws Exception
	{
		Series series;
		try {
			series = service.getSeries(seriesId, apiKey, RETURNTYPE);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		
		if (series != null)
		{
			if (withData)
			{
				addObservations(series);
			}
		}
		else
			throw new Exception("Error finding series");
		return series;
	}

	public Category getCategoryById(int categoryId) throws Exception
	{
		Category category;
		try {
			category = service.getCategoryById(categoryId, apiKey, RETURNTYPE);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

		return category;
	}

	public List<Category> getCategoryChildren(int categoryId) throws Exception
	{
		CategoryCollection categories;
		try {
			categories = service.getCategoryChildren(categoryId, apiKey, RETURNTYPE);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		
		return categories.getCategories();
	}

	public Release getReleaseById(int releaseId) throws Exception
	{
		Release release;
		try {
			release = service.getReleaseById(releaseId, apiKey, RETURNTYPE);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		
		return release;
	}

	public List<Series> getSeriesByReleaseId(int releaseId) throws Exception
	{
		SeriesCollection seriesCollection;
		try {
			seriesCollection = service.getSeriesByReleaseId(releaseId, apiKey, RETURNTYPE);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		
		return seriesCollection.getSeries();
	}
	
	public List<Series> getSeriesByCategoryId(int categoryId) throws Exception
	{
		SeriesCollection seriesCollection;
		try {
			seriesCollection = service.getSeriesByCategoryId(categoryId, apiKey, RETURNTYPE);
		}
		catch (Exception e)
		{
			log.error(e);
			throw e;
		}
		return seriesCollection.getSeries();
	}
}
