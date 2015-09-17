package org.apache.cordova.labs.keyboard;


import android.content.res.Configuration;
import android.InputMethodService;


public class MyInputMethodService extends InputMethodService {
    Configuration config = getResources().getConfiguration();
    config.keyboard = 1;
    config.hardKeyboardHidden == 2;
    
    @Override
    public boolean onEvaluateInputViewShown() {
        return true;
    }
}
