package com.LiL.Wayne.Activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.LiL.Wayne.Activity.R;
import com.audamob.audasingers.tool.view.ImageResizerUtils;

public class DialogActivity extends Activity {
	Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.auda_layout_create_dialog);
		activity=this;
		
		ViewGroup mainContainer = (ViewGroup) findViewById(R.id.MainContainer);
		Typeface font = Typeface.createFromAsset(getAssets(), "ExoMedium.otf");

		ImageResizerUtils.setFont(this, mainContainer, font);
		Bundle b = getIntent().getExtras();

		TextView dialogMsg = (TextView) findViewById(R.id.dialogMsg);
		dialogMsg.setText("There are a new version in play store, get it now !");
		
		TextView cancel = (TextView) findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
		TextView OK = (TextView) findViewById(R.id.ok);
		OK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {

					Intent intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=com.LiL.Wayne.Activity" ));
					startActivity(intent);

				} catch (Exception e) {
					Intent i = new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("https://play.google.com/store/apps/details?id=com.LiL.Wayne.Activity"));
					activity.startActivity(i);
				}

				finish();
			}
		});

	}
}