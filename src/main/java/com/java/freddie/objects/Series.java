package com.java.freddie.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class Series implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1655972251189671476L;

	private String id;
	private String title;
	private List<Observation> data;
	private String seasonalAdjustment;
	private String seasonalAdjustmentShort;
	private String frequency;
	private String frequencyShort;
	private String units;
	private String unitsShort;
	private Date realtimeStart;
	private Date realtimeEnd;
	private Date observationStart;
	private Date observationEnd;
	private Date lastUpdated;
	private Integer popularity;
	private String notes;

	public Series()
	{}

	public Series(String id)
	{
		setId(id);
	}

	public Series(String id, List<Observation> observations)
	{
		setId(id);
		setData(observations);
	}

	public Series(String id, String title, List<Observation> data, String seasonalAdjustment, String seasonalAdjustmentShort,
			String frequency, String frequencyShort, String units, String unitsShort, Date realtimeStart, Date realtimeEnd,
			Date observationStart, Date observationEnd, Date lastUpdated, Integer popularity, String notes)
	{
		super();
		this.id = id;
		this.title = title;
		this.data = data;
		this.seasonalAdjustment = seasonalAdjustment;
		this.seasonalAdjustmentShort = seasonalAdjustmentShort;
		this.frequency = frequency;
		this.frequencyShort = frequencyShort;
		this.units = units;
		this.unitsShort = unitsShort;
		this.realtimeStart = realtimeStart;
		this.realtimeEnd = realtimeEnd;
		this.observationStart = observationStart;
		this.observationEnd = observationEnd;
		this.lastUpdated = lastUpdated;
		this.popularity = popularity;
		this.notes = notes;
	}

	public TreeMap<Date, Double> getCurve()
	{
		TreeMap<Date, Double> output = new TreeMap<>();
		for (Observation obs : getData())
		{
			output.put(obs.date, obs.value);
		}
		return output;
	}

	public List<Observation> getData()
	{
		return data;
	}

	public void setData(List<Observation> data)
	{
		this.data = data;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getSeasonalAdjustment()
	{
		return seasonalAdjustment;
	}

	public void setSeasonalAdjustment(String seasonalAdjustment)
	{
		this.seasonalAdjustment = seasonalAdjustment;
	}

	public String getSeasonalAdjustmentShort()
	{
		return seasonalAdjustmentShort;
	}

	public void setSeasonalAdjustmentShort(String seasonalAdjustmentShort)
	{
		this.seasonalAdjustmentShort = seasonalAdjustmentShort;
	}

	public String getFrequency()
	{
		return frequency;
	}

	public void setFrequency(String frequency)
	{
		this.frequency = frequency;
	}

	public String getFrequencyShort()
	{
		return frequencyShort;
	}

	public void setFrequencyShort(String frequencyShort)
	{
		this.frequencyShort = frequencyShort;
	}

	public String getUnits()
	{
		return units;
	}

	public void setUnits(String units)
	{
		this.units = units;
	}

	public String getUnitsShort()
	{
		return unitsShort;
	}

	public void setUnitsShort(String unitsShort)
	{
		this.unitsShort = unitsShort;
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

	public Date getObservationStart()
	{
		return observationStart;
	}

	public void setObservationStart(Date observationStart)
	{
		this.observationStart = observationStart;
	}

	public Date getObservationEnd()
	{
		return observationEnd;
	}

	public void setObservationEnd(Date observationEnd)
	{
		this.observationEnd = observationEnd;
	}

	public Date getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}

	public Integer getPopularity()
	{
		return popularity;
	}

	public void setPopularity(Integer popularity)
	{
		this.popularity = popularity;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

}
