package com.java.freddie.helpers;

import java.util.ArrayList;
import java.util.List;

import com.java.freddie.objects.Category;

public class CategoryCollection
{

	private List<Category> categories = new ArrayList<>();

	public CategoryCollection()
	{}

	public void addCategory(Category category)
	{
		categories.add(category);
	}

	public List<Category> getCategories()
	{
		return categories;
	}

	public void setCategories(List<Category> categories)
	{
		this.categories = categories;
	}
}
