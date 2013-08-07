package com.nachuantech.opensync;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class StyleTextView extends TextView {
	public StyleTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public StyleTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public StyleTextView(Context context) {
		super(context);
		init();
	}

	public void init() {
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
				"font/helr45w.ttf");
		setTypeface(tf, 1);

	}
}
