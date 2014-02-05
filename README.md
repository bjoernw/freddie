Freddie
------
The unofficial [St. Louis Fed FRED API](http://api.stlouisfed.org/docs/fred/) Java Wrapper

[Get a valid API key](http://api.stlouisfed.org/api_key.html) 
```java
String apiKey = "51ff1f1844537b524db28bddc9de4d44";
String seriesId = "M08175USM144NNBR";
Freddie freddie = new Freddie(apiKey);

/*
 * This series will not be populated with observation data.
 * However, it will contain all the series' metadata.
 */
Series series = freddie.getSeriesById(seriesId, false);
assert (series.getData() == null);

/*
 * This one will contain both actual observational data and metadata.
 */
Series seriesWithData = freddie.getSeriesById(seriesId, true);

for (Observation o : seriesWithData.getData())
{
	System.out.println(seriesWithData.getId() + " Date: " + o.getDate() + " ----- " + o.getValue());
}
```

The following FRED API objects are currently mapped to pojos:
* Series
* Category
* Release
