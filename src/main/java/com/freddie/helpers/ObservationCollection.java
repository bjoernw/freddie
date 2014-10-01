package com.freddie.helpers;

import java.util.ArrayList;
import java.util.List;

import com.freddie.objects.Observation;

public class ObservationCollection
{

	List<Observation> observations = new ArrayList<>();

	public ObservationCollection()
	{
		super();
	}

	public void addObservation(Observation obs)
	{
		this.observations.add(obs);
	}

	public List<Observation> getObservations()
	{
		return observations;
	}

	public void setObservations(List<Observation> observations)
	{
		this.observations = observations;
	}
}
