package org.apache.cordova.labs.keyboard;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.InputMethodService;
import android.view.View;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class MyInputMethodService extends InputMethodService {
    @Override
    public boolean onEvaluateInputViewShown() {
        return true;
    }
}
