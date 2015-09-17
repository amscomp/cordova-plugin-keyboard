package org.apache.cordova.labs.keyboard;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.view.View;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.Context;
import android.inputmethodservice.InputMethodService;

public class Keyboard extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    	
    	Resources res = context.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.keyboard = 1;
        conf.hardKeyboardHidden = 2;
        res.updateConfiguration(conf, dm);
    	
	InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
	View view;
	try {
	    view = (View)webView.getClass().getMethod("getView").invoke(webView);
	}
	catch (Exception e){
	    view = (View)webView;
	}

	if("show".equals(action)){
	    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
	    callbackContext.success();
	    return true;
	}
	else if("hide".equals(action)){
	    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	    callbackContext.success();
	    return true;
	}
	callbackContext.error(action + " is not a supported action");
	return false;
    }
}
