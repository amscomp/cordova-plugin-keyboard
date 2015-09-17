package org.apache.cordova.labs.keyboard;


import android.content.res.Configuration;
import android.InputMethodService;


public class MyInputMethodService extends InputMethodService {
    
    @Override
    public boolean onEvaluateInputViewShown() {
        return true;
    }
}
