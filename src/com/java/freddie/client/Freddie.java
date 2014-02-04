package com.java.freddie.client;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.GsonConverter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.freddie.api.definition.IFredApiService;
import com.java.freddie.deserializers.CategoryCollectionDeserializer;
import com.java.freddie.deserializers.CategoryDeserializer;
import com.java.freddie.deserializers.ObservationCollectionDeserializer;
import com.java.freddie.deserializers.ReleaseDeserializer;
import com.java.freddie.deserializers.SeriesDeserializer;
import com.java.freddie.helpers.CategoryCollection;
import com.java.freddie.helpers.ObservationCollection;
import com.java.freddie.helpers.SeriesCollection;
import com.java.freddie.objects.Category;
import com.java.freddie.objects.Release;
import com.java.freddie.objects.Series;

/**
 * @author bweidlich
 * 
 */
public class Freddie
{

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

	public Freddie(String apiKey)
	{
		this(apiKey, "http://api.stlouisfed.org/fred/");
	}

	public Freddie(String apiKey, String optEndPoint)
	{
		setApiKey(apiKey);
		if (optEndPoint != null && !optEndPoint.isEmpty())
			setEndPoint(optEndPoint);

		restAdapter =
				new RestAdapter.Builder().setEndpoint(endPoint).setLogLevel(LogLevel.FULL).setConverter(new GsonConverter(gson))
						.build();
		service = restAdapter.create(IFredApiService.class);
	}


	/**
	 * @param series Series for which to fetch observations
	 * @return same Series object
	 */
	public Series addObservations(Series series)
	{
		if (series.getData() != null && !series.getData().isEmpty())
			return series;

		ObservationCollection observations = service.getObservations(series.getId(), apiKey, RETURNTYPE);
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
		Series series = service.getSeries(seriesId, apiKey, RETURNTYPE);

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

	public Category getCategoryById(int categoryId)
	{
		IFredApiService service = restAdapter.create(IFredApiService.class);
		Category category = service.getCategoryById(categoryId, apiKey, RETURNTYPE);

		return category;
	}

	public List<Category> getCategoryChildren(int categoryId)
	{
		CategoryCollection categories = service.getCategoryChildren(categoryId, apiKey, RETURNTYPE);
		return categories.getCategories();
	}

	public Release getReleaseById(int releaseId)
	{
		Release release = service.getReleaseById(releaseId, apiKey, RETURNTYPE);
		return release;
	}

	public List<Series> getSeriesByReleaseId(int releaseId)
	{
		SeriesCollection seriesCollection = service.getSeriesByReleaseId(releaseId, apiKey, RETURNTYPE);
		return seriesCollection.getSeries();
	}

	public String getApiKey()
	{
		return apiKey;
	}

	public void setApiKey(String apiKey)
	{
		this.apiKey = apiKey;
	}

	public String getEndPoint()
	{
		return endPoint;
	}

	public void setEndPoint(String endPoint)
	{
		this.endPoint = endPoint;
	}
}
