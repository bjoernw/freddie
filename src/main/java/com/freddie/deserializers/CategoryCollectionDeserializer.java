package com.freddie.deserializers;

import com.freddie.helpers.CategoryCollection;
import com.freddie.objects.Category;
import com.google.gson.*;

import java.lang.reflect.Type;

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
