package com.app42sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app42sample.R;
import com.app42sample.App42ServiceAPI.App42ServiceListener;
import com.shephertz.app42.paas.sdk.android.App42Activity;
import com.shephertz.app42.paas.sdk.android.App42Response;
import com.shephertz.app42.paas.sdk.android.user.User;



public class LoginActivity extends App42Activity implements App42ServiceListener {

	 private App42ServiceAPI asyncService;
	 private EditText userName;
	 private EditText password;   
	 private EditText emailid;       
	private ProgressDialog progressDialog;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	 	setContentView(R.layout.login);
		((TextView) findViewById(R.id.page_header)).setText("Login Activty");
		userName = (EditText) this.findViewById(R.id.uname);
		password = (EditText) this.findViewById(R.id.pswd);
		emailid = (EditText) this.findViewById(R.id.email);
		asyncService=App42ServiceAPI.instance(this);
	}
 
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	public void onStart() {
		super.onStart();
	}

	public void onSigninClicked(View view) {
		progressDialog = ProgressDialog.show(this, "", "signing in..");
		progressDialog.setCancelable(true);
		asyncService.authenticateUser(userName.getText().toString(), password
				.getText().toString(), this);
	}

	public void onRegisterClicked(View view) {
		progressDialog = ProgressDialog.show(this, "", "registering..");
 		progressDialog.setCancelable(true);
		asyncService.createUser(userName.getText().toString(), password
				.getText().toString(), emailid.getText().toString(), this);
	}
	

	private void gotoHomeActivity(String signedInUserName) {
		// Finish the splash activity so it can't be returned to.
		this.finish();
		Intent mainIntent = new Intent(this, MainActivity.class);
		this.startActivity(mainIntent);
	}

	@Override
	public void onUserCreated(final User user) {
		progressDialog.dismiss();
		if (user != null) {
			//gotoHomeActivity(userName.getText().toString());
			Toast.makeText(this, "User successfully registered , Please Login", Toast.LENGTH_SHORT)
			.show();
		} else {
			Toast.makeText(this, "User creation failed.", Toast.LENGTH_SHORT)
					.show();
		}
	}

	@Override
	public void onUserAuthenticated(final App42Response response) {
		progressDialog.dismiss();
		if (response != null) {
			System.out.println(response.toString());
			gotoHomeActivity(userName.getText().toString());
		} else {
			Toast.makeText(this, "Authentication failed..!!",
					Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
	}

}
