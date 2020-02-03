package org.d3ifcool.cloure.listeners;

import android.app.Activity;
import android.view.View;

import org.d3ifcool.cloure.MyMenuActivity;

public class ToWindowOnClickWithClosing extends ToWindowOnClick {
    public ToWindowOnClickWithClosing(Activity fromActivity, Class<? extends Activity> toActivityClass) {
        super(fromActivity, toActivityClass);
    }

    @Override
    public void onClick(View v) {
        if (!MyMenuActivity.isOpen) {
            super.onClick(v);
        }
        fromActivity.finish();
    }
}
