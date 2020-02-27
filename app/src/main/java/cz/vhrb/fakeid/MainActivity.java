package cz.vhrb.fakeid;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import cz.vhrb.fakeid.retrofit.Client;
import cz.vhrb.fakeid.retrofit.FakeId;
import cz.vhrb.fakeid.retrofit.UINamesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
	private ImageView avatar;
	private TextView name;
	private TextView sex;
	private TextView country;
	private TextView phone;
	private TextView bdate;
	private TextView email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		avatar = findViewById(R.id.avatar);
		name = findViewById(R.id.name);
		sex = findViewById(R.id.sex);
		country = findViewById(R.id.country);
		phone = findViewById(R.id.phone);
		bdate = findViewById(R.id.bdate);
		email = findViewById(R.id.email);

		UINamesService http = Client.getClient().create(UINamesService.class);

		http.ext().enqueue(new Callback<FakeId>() {
			@Override
			public void onResponse(Call<FakeId> call, Response<FakeId> response) {
				if (!response.isSuccessful()) {
					// error
					return;
				}

				FakeId fakeId = response.body();
				assert fakeId != null;

				name.setText(fakeId.getName());
				sex.setText(fakeId.getGender());
				country.setText(fakeId.getRegion());
				phone.setText(fakeId.getPhone());
				bdate.setText(fakeId.getBirthday().getDmy());
				email.setText(fakeId.getEmail());

				Picasso.get().load(fakeId.getPhoto()).into(avatar);
			}

			@Override
			public void onFailure(Call<FakeId> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
