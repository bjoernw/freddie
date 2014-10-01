package com.java.freddie.deserializers;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.java.freddie.objects.Category;

public class CategoryDeserializer implements JsonDeserializer<Category>
{

	@Override
	public Category deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException
	{
		JsonObject obj = (JsonObject) json;
		JsonArray obsArray = obj.get("categories").getAsJsonArray();
		Category category = new Category();

		if (obsArray.size() == 1)
		{
			JsonObject catObj = obsArray.get(0).getAsJsonObject();
			category.setId(catObj.get("id").getAsInt());
			category.setName(catObj.get("name").getAsString());
			category.setParentId(catObj.get("parent_id").getAsInt());
		}

		return category;
	}
}
