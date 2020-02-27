package cz.vhrb.fakeid.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UINamesService {
	@GET("/api?ext")
	Call<FakeId> ext();
}
