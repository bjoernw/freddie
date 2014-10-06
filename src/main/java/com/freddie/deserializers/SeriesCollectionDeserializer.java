package com.freddie.deserializers;

import com.freddie.helpers.SeriesCollection;
import com.freddie.objects.Series;
import com.google.gson.*;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SeriesCollectionDeserializer implements JsonDeserializer<SeriesCollection>
{
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss-SS");
	private static final Logger log = Logger.getLogger(SeriesCollectionDeserializer.class);

	@Override
	public SeriesCollection deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException
	{
		SeriesCollection collection = new SeriesCollection();
		JsonObject obj = (JsonObject) json;
		JsonArray obsArray = obj.get("seriess").getAsJsonArray();

		for (JsonElement c : obsArray)
		{
			JsonObject seriesObj = (JsonObject) c;
			Series series = new Series();
			try
			{
				series.setId(seriesObj.get("id").getAsString());
				series.setTitle(seriesObj.get("title").getAsString());
				series.setFrequency(seriesObj.get("frequency").getAsString());
				series.setFrequencyShort(seriesObj.get("frequency_short").getAsString());
				series.setUnits(seriesObj.get("units").getAsString());
				series.setUnitsShort(seriesObj.get("units_short").getAsString());
				series.setNotes(seriesObj.get("notes").getAsString());
				series.setPopularity(seriesObj.get("popularity").getAsInt());
				series.setSeasonalAdjustment(seriesObj.get("seasonal_adjustment").getAsString());
				series.setSeasonalAdjustmentShort(seriesObj.get("seasonal_adjustment_short").getAsString());
			}
			catch(Exception e)
			{
				log.error("Gson Parse Error" + e.getMessage());
			}



			try
			{
				series.setLastUpdated(timestampFormat.parse(seriesObj.get("last_updated").getAsString()));
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error" + e.getMessage());
			}
			try
			{
				series.setRealtimeStart(sdf.parse(seriesObj.get("realtime_start").getAsString()));
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error" + e.getMessage());
			}

			try
			{
				series.setRealtimeEnd(sdf.parse(seriesObj.get("realtime_end").getAsString()));
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error" + e.getMessage());
			}
			collection.addSeries(series);
		}
		return collection;
	}
}
