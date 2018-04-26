package yuku.ambilwarna.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import yuku.ambilwarna.AmbilWarnaDialog;

public class AmbilWarnaDemoActivity extends Activity {
	TextView text1;
	int color = 0xffffff00;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final View button1 = findViewById(R.id.button1);
		final View button2 = findViewById(R.id.button2);
		final View button3 = findViewById(R.id.button3);
		text1 = (TextView) findViewById(R.id.text1);
		displayColor();

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openDialog(false);
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openDialog(true);
			}
		});

		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AmbilWarnaDemoPreferenceActivity.class));
			}
		});
	}

	void openDialog(boolean supportsAlpha) {
		AmbilWarnaDialog dialog = new AmbilWarnaDialog(AmbilWarnaDemoActivity.this, color, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
			@Override
			public void onOk(AmbilWarnaDialog dialog, int color) {
				Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
				AmbilWarnaDemoActivity.this.color = color;
				displayColor();
			}

			@Override
			public void onCancel(AmbilWarnaDialog dialog) {
				Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onChange(AmbilWarnaDialog dialog, int color) {
				Log.d("AmbilWarnaDemoActivity", "Color live update: " + color);
			}
		});
		dialog.show();
	}

	void displayColor() {
		text1.setText(String.format("Current color: 0x%08x", color));
	}
}