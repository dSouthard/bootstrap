package com.dsouthard.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Data de-serialization class to de-serialize the date field from database storage
 * 
 * @author D. Southard 
 */
@Component
public class JSONDeserialize extends JsonDeserializer<Date>{

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Date deserialize(JsonParser jpar, DeserializationContext descon) throws IOException, JsonProcessingException {
		
		String date = jpar.getText();
		
		Date dateSer = null;
		
		try {
			dateSer = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return dateSer;
	}
	

}
