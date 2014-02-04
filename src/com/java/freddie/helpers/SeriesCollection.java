package com.java.freddie.helpers;

import java.util.ArrayList;
import java.util.List;

import com.java.freddie.objects.Series;

public class SeriesCollection
{
	List<Series> series = new ArrayList<>();

	public SeriesCollection()
	{}

	public void addSeries(Series series)
	{
		this.series.add(series);
	}

	public List<Series> getSeries()
	{
		return series;
	}

	public void setSeries(List<Series> series)
	{
		this.series = series;
	}
}
