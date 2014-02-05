package com.java.client.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.freddie.client.Freddie;
import com.java.freddie.objects.Category;
import com.java.freddie.objects.Release;
import com.java.freddie.objects.Series;

public class FredApiTest
{

	Freddie service = null;

	@Before
	public void setUp() throws Exception
	{
		String apiKey = "51ff1f1844537b524db28bddc9de4d4c";
		service = new Freddie(apiKey);
	}

	@Test
	public void seriesTestNoData() throws Exception
	{
		Series series = service.getSeriesById("M08175USM144NNBR", false);

		Assert.assertNotNull(series);
		Assert.assertNotNull(series.getId());
		Assert.assertNull(series.getData());
	}

	@Test
	public void seriesTestWithData() throws Exception
	{
		Series series = service.getSeriesById("M08175USM144NNBR", true);

		Assert.assertNotNull(series);
		Assert.assertNotNull(series.getId());
		Assert.assertNotNull(series.getData());
		Assert.assertTrue(!series.getData().isEmpty());
	}

	@Test
	public void categoryTest()
	{
		Category category = service.getCategoryById(1);
		Assert.assertNotNull(category);
		Assert.assertNotNull(category.getName());
		Assert.assertNotNull(category.getId());
		Assert.assertNotNull(category.getParentId());
	}

	@Test
	public void categoryChildrenTest()
	{
		List<Category> children = service.getCategoryChildren(1);
		Assert.assertNotNull(children);
		Assert.assertTrue(!children.isEmpty());
		for (Category c : children)
		{
			Assert.assertNotNull(c);
			Assert.assertNotNull(c.getName());
			Assert.assertNotNull(c.getId());
			Assert.assertNotNull(c.getParentId());
		}
	}

	@Test
	public void releaseTest()
	{
		Release release = service.getReleaseById(53);
		Assert.assertNotNull(release);
		Assert.assertNotNull(release.getName());
		Assert.assertNotNull(release.getId());
		Assert.assertNotNull(release.getPressRelease());
		Assert.assertNotNull(release.getRealtimeStart());
		Assert.assertNotNull(release.getRealtimeEnd());
	}

	@Test
	public void releaseSeriesTest() throws Exception
	{
		List<Series> series = service.getSeriesByReleaseId(53);

		for (Series s : series)
		{
			Assert.assertNotNull(s);
			Assert.assertNotNull(s.getId());
			Assert.assertNull(s.getData());
			Assert.assertTrue(s.getData().isEmpty());
		}
	}
	
	@Test
	public void categorySeriesTest()
	{
		List<Series> series = service.getSeriesByCategoryId(1);
		
		for (Series s : series)
		{
			System.out.println(s.getId());
			Assert.assertNotNull(s);
			Assert.assertNotNull(s.getId());
			Assert.assertNull(s.getData());
			Assert.assertTrue(s.getData().isEmpty());
		}
	}
}
