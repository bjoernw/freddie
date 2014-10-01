package com.java.freddie.deserializers;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.java.freddie.helpers.ObservationCollection;
import com.java.freddie.objects.Observation;


public class ObservationCollectionDeserializer implements JsonDeserializer<ObservationCollection>
{

	private static final Logger log = Logger.getLogger(ObservationCollectionDeserializer.class);

	@Override
	public ObservationCollection deserialize(
			JsonElement json,
			Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException
	{
		JsonObject obj = (JsonObject) json;
		JsonElement obsArray = obj.get("observations");

		assert (obsArray.isJsonArray());
		ObservationCollection collection = new ObservationCollection();

		JsonArray observations = (JsonArray) obsArray;
		for (JsonElement obs : observations)
		{
			JsonObject objObs = (JsonObject) obs;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date realtimeStart;
			try
			{
				realtimeStart = sdf.parse(objObs.get("realtime_start").getAsString());
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error");
				return null;
			}
			Date realtimeEnd;
			try
			{
				realtimeEnd = sdf.parse(objObs.get("realtime_end").getAsString());
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error");
				return null;
			}
			Date date;
			try
			{
				date = sdf.parse(objObs.get("date").getAsString());
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error");
				return null;
			}
			Double value = objObs.get("value").getAsDouble();
			collection.addObservation(new Observation(realtimeStart, realtimeEnd, date, value));
		}
		return collection;

	}

}
