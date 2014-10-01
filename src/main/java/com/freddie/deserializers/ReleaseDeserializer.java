package com.freddie.deserializers;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.freddie.objects.Release;


public class ReleaseDeserializer implements JsonDeserializer<Release>
{

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final Logger log = Logger.getLogger(ReleaseDeserializer.class);

	@Override
	public Release deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException
	{
		JsonObject obj = (JsonObject) json;
		JsonArray obsArray = obj.get("releases").getAsJsonArray();
		Release release = new Release();
		if (obsArray.size() == 1)
		{
			JsonObject releaseObj = obsArray.get(0).getAsJsonObject();
			release.setId(releaseObj.get("id").getAsInt());
			release.setLink(releaseObj.get("link").getAsString());
			release.setPressRelease(releaseObj.get("press_release").getAsBoolean());
			release.setId(releaseObj.get("id").getAsInt());
			release.setName(releaseObj.get("name").getAsString());

			try
			{
				release.setRealtimeStart(sdf.parse(releaseObj.get("realtime_start").getAsString()));
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error" + e.getMessage());
			}

			try
			{
				release.setRealtimeEnd(sdf.parse(releaseObj.get("realtime_end").getAsString()));
			}
			catch (ParseException e)
			{
				log.error("Gson Parse Error" + e.getMessage());
			}
		}
		return release;
	}
}
