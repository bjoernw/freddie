package com.freddie.client;

import com.freddie.objects.Category;
import com.freddie.objects.Release;
import com.freddie.objects.Series;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FreddieTest
{

	Freddie service = null;

	@Before
	public void setUp() throws Exception
	{
		String apiKey = "51ff1f1844537b524db28bddc9de4d4c";
		service = new Freddie(apiKey, null, 10);
	}

	@Test
	public void testGetSeriesById() throws Exception
	{
		Series series = service.getSeriesById("M08175USM144NNBR", false);

		Assert.assertNotNull(series);
		Assert.assertNotNull(series.getId());
		Assert.assertNull(series.getData());
	}

	@Test
	public void testGetSeriesByIdWithData() throws Exception
	{
		Series series = service.getSeriesById("M08175USM144NNBR", true);

		Assert.assertNotNull(series);
		Assert.assertNotNull(series.getId());
		Assert.assertNotNull(series.getData());
		Assert.assertTrue(!series.getData().isEmpty());
	}

	@Test
	public void testGetCategoryById() throws Exception
	{
		Category category = service.getCategoryById(1);
		Assert.assertNotNull(category);
		Assert.assertNotNull(category.getName());
		Assert.assertNotNull(category.getId());
		Assert.assertNotNull(category.getParentId());
	}

	@Test
	public void testGetCategoryChildren() throws Exception
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
	public void testGetReleaseById() throws Exception
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
	public void testGetSeriesByReleaseId() throws Exception
	{
		List<Series> series = service.getSeriesByReleaseId(53);

		for (Series s : series)
		{
			Assert.assertNotNull(s);
			Assert.assertNotNull(s.getId());
			Assert.assertNull(s.getData());
		}
	}

	@Test
	public void testGetSeriesByCategoryId() throws Exception
	{
		List<Series> series = service.getSeriesByCategoryId(1);

		for (Series s : series)
		{
			System.out.println(s.getId());
			Assert.assertNotNull(s);
			Assert.assertNotNull(s.getId());
			Assert.assertNull(s.getData());
		}
	}
}
