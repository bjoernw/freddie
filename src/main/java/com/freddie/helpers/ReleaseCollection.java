package com.freddie.helpers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.freddie.objects.Release;

public class ReleaseCollection implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3251027846769579054L;
	private Date realtimeStart;
	private Date realtimeEnd;
	private String orderBy;
	private String sortOrder;
	private Integer count;
	private Integer offset;
	private Integer limit;
	private List<Release> releases;

	public ReleaseCollection(Date realtimeStart, Date realtimeEnd, String orderBy, String sortOrder, Integer count,
			Integer offset, Integer limit, List<Release> releases)
	{
		super();
		this.realtimeStart = realtimeStart;
		this.realtimeEnd = realtimeEnd;
		this.orderBy = orderBy;
		this.sortOrder = sortOrder;
		this.count = count;
		this.offset = offset;
		this.limit = limit;
		this.releases = releases;
	}

	public Date getRealtimeStart()
	{
		return realtimeStart;
	}

	public void setRealtimeStart(Date realtimeStart)
	{
		this.realtimeStart = realtimeStart;
	}

	public Date getRealtimeEnd()
	{
		return realtimeEnd;
	}

	public void setRealtimeEnd(Date realtimeEnd)
	{
		this.realtimeEnd = realtimeEnd;
	}

	public String getOrderBy()
	{
		return orderBy;
	}

	public void setOrderBy(String orderBy)
	{
		this.orderBy = orderBy;
	}

	public String getSortOrder()
	{
		return sortOrder;
	}

	public void setSortOrder(String sortOrder)
	{
		this.sortOrder = sortOrder;
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public Integer getOffset()
	{
		return offset;
	}

	public void setOffset(Integer offset)
	{
		this.offset = offset;
	}

	public Integer getLimit()
	{
		return limit;
	}

	public void setLimit(Integer limit)
	{
		this.limit = limit;
	}

	public List<Release> getReleases()
	{
		return releases;
	}

	public void setReleases(List<Release> releases)
	{
		this.releases = releases;
	}


}
