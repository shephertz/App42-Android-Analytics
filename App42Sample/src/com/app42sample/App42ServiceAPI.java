package com.app42sample;


import android.content.Context;
import android.os.Handler;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42Exception;
import com.shephertz.app42.paas.sdk.android.App42Response;
import com.shephertz.app42.paas.sdk.android.user.User;
import com.shephertz.app42.paas.sdk.android.user.UserService;



 
public class App42ServiceAPI{
	private UserService userService;
	private static App42ServiceAPI mInstance = null;
	private App42ServiceAPI(Context context) {
		App42API.initialize(context, Constants.App42ApiKey, Constants.App42ApiSecret);
		this.userService = App42API.buildUserService();
	}

	/*
	 * instance of class
	 */
	public static App42ServiceAPI instance(Context context) {

		if (mInstance == null) {
			mInstance = new App42ServiceAPI(context);
		}

		return mInstance;
	}

	
	/*
	 * This function allows to create user using APP42 service
	 */
	public void createUser(final String name, final String pswd,
			final String email, final App42ServiceListener callBack) {
		final Handler callerThreadHandler = new Handler();
		new Thread() {
			@Override
			public void run() {
				try {
					final User user = userService.createUser(name, pswd, email);
					callerThreadHandler.post(new Runnable() {
						@Override
						public void run() {
							callBack.onUserCreated(user);
						}
					});
				} catch (final App42Exception ex) {
					callerThreadHandler.post(new Runnable() {
						@Override
						public void run() {   
							if (callBack != null) {
								System.out.println(ex.toString());
								callBack.onUserCreated(null);
							}
						}
					});

				}
			}
		}.start();
	}
	
	/*
	 * This function validate user's authentication with APP42
	 */
	public void authenticateUser(final String name, final String pswd,
			final App42ServiceListener callBack) {
		final Handler callerThreadHandler = new Handler();
		new Thread() {
			@Override
			public void run() {
				try {
					final App42Response response = userService.authenticate(
							name, pswd);
					callerThreadHandler.post(new Runnable() {
						@Override
						public void run() {
							callBack.onUserAuthenticated(response);
						}
					});
				} catch (final App42Exception ex) {
					callerThreadHandler.post(new Runnable() {
						@Override
						public void run() {
							if (callBack != null) {
								System.out.println(ex.toString());
								callBack.onUserAuthenticated(null);
							}
						}
					});
				}
			}
		}.start();
	}
	

	public static interface App42ServiceListener {
		public void onUserCreated(User response);

		public void onUserAuthenticated(App42Response response);

		
	}
}