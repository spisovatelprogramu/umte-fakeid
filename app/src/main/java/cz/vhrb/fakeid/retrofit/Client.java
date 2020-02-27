package cz.vhrb.fakeid.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Client {
	private static Retrofit retrofit;

	public static Retrofit getClient() {
		if (retrofit != null) {
			return retrofit;
		}

		retrofit = new Retrofit.Builder()
				.baseUrl("https://uinames.com")
				.addConverterFactory(JacksonConverterFactory.create())
				.build();

		return retrofit;
	}

}
