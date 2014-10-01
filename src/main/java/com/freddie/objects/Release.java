package com.freddie.objects;

import java.io.Serializable;
import java.util.Date;

public class Release implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6077301204908146697L;

	private Date realtimeStart;
	private Date realtimeEnd;
	private int id;
	private String name;
	private Boolean pressRelease;
	private String link;

	public Release()
	{}

	public Release(Date realtimeStart, Date realtimeEnd, int id, String name, Boolean pressRelease, String link)
	{
		super();
		this.realtimeStart = realtimeStart;
		this.realtimeEnd = realtimeEnd;
		this.id = id;
		this.name = name;
		this.pressRelease = pressRelease;
		this.link = link;
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

	public Boolean getPressRelease()
	{
		return pressRelease;
	}

	public void setPressRelease(Boolean pressRelease)
	{
		this.pressRelease = pressRelease;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}
}
