package com.java.freddie.deserializers;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.java.freddie.helpers.CategoryCollection;
import com.java.freddie.objects.Category;

public class CategoryCollectionDeserializer implements JsonDeserializer<CategoryCollection>
{

	@Override
	public CategoryCollection deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException
	{
		CategoryCollection collection = new CategoryCollection();
		JsonObject obj = (JsonObject) json;
		JsonArray obsArray = obj.get("categories").getAsJsonArray();

		for (JsonElement c : obsArray)
		{
			JsonObject o = (JsonObject) c;
			collection.addCategory(new Category(o.get("id").getAsInt(), o.get("name").getAsString(), o.get("parent_id")
					.getAsInt()));
		}
		return collection;
	}
}
