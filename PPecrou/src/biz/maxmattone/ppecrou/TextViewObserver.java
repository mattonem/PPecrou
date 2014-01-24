package biz.maxmattone.ppecrou;

import java.util.Observable;
import java.util.Observer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewObserver extends TextView implements Observer {


	public TextViewObserver(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public TextViewObserver(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public TextViewObserver(Context context) {
		super(context);
	}

	@Override
	public void update(Observable observable, Object data) {
		setText(observable.toString());

	}

}
