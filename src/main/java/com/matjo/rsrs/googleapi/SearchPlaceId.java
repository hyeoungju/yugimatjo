package com.matjo.rsrs.googleapi;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SearchPlaceId {
	public String placeId() {
		OkHttpClient client = new OkHttpClient().newBuilder()
		  .build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		HttpUrl base = HttpUrl.parse("https://maps.googleapis.com/maps/api/place/findplacefromtext/test");
		HttpUrl link = base.resolve("json?input=Museum%20of%20Contemporary%20Art%20Australia&inputtype=textquery&key=AIzaSyDnHdrBDEvUp0BRbUiKE1vhmWclLRRZ400");
		Request request = new Request.Builder()
		  .url(link)
		  .method("GET", null)
		  .build();
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(request.toString());
		return "";
	}
	
	public static void main(String[] args) {
		SearchPlaceId sp = new SearchPlaceId();
		sp.placeId();
	}
}



