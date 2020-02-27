package cz.vhrb.fakeid.retrofit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FakeId {
	private String name;
	private String surname;
	private String gender;
	private String region;
	private String phone;
	private Birthday birthday;
	private String email;
	private String photo;

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Birthday {
		private String dmy;
	}
}
