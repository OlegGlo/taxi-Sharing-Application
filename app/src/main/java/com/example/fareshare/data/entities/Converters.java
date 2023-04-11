package com.example.fareshare.data.entities;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@ProvidedTypeConverter
public class Converters {
    @TypeConverter
    public static ArrayList<CustomerInfo> fromString(String value) {
        Type listType = new TypeToken<ArrayList<CustomerInfo>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromArrayList(ArrayList<CustomerInfo> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
    @TypeConverter
    public static ArrayList<Request> fromString2(String value) {
        Type listType = new TypeToken<ArrayList<Request>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromArrayList2(ArrayList<Request> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
    @TypeConverter
    public static Offer fromString3(String value) {
        Type listType = new TypeToken<Offer>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromOffer(Offer offer) {
        Gson gson = new Gson();
        String json = gson.toJson(offer);
        return json;
    }
}
