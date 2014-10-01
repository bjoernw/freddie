package com.freddie.objects;

import java.io.Serializable;

public class Category implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1868282763564612632L;
	private int id;
	private String name;
	private int parentId;

	public Category()
	{}

	public Category(int id, String name, int parentId)
	{
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getParentId()
	{
		return parentId;
	}

	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}

}
