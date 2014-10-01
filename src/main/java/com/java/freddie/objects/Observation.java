package com.java.freddie.objects;

import java.io.Serializable;
import java.util.Date;

public class Observation implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7557216989167725505L;
	public Date realtimeStart;
	public Date realtimeEnd;
	public Date date;
	public Double value;

	public Observation(Date realtimeStart, Date realtimeEnd, Date date, Double value)
	{
		super();
		this.realtimeStart = realtimeStart;
		this.realtimeEnd = realtimeEnd;
		this.date = date;
		this.value = value;
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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Double getValue()
	{
		return value;
	}

	public void setValue(Double value)
	{
		this.value = value;
	}
}
