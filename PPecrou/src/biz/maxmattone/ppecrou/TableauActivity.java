package biz.maxmattone.ppecrou;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class TableauActivity extends Activity {

	private DecimalFormat decimalFormat;
	private final String stateD0 = "D0";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tableau);
		decimalFormat = new DecimalFormat("##0.###E0");
		EditText inputD0 = (EditText) findViewById(R.id.inputD0);
		EditText inputT = (EditText) findViewById(R.id.inputT);
		
		
		
		inputT.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				
				return false;
			}
		});
		
		inputD0.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				updateD0(Float.parseFloat(v.getText().toString()));
				
				return false;
			}
		});
	}
	
	public void updateD0(float d0){
		TextView europincemin = (TextView) findViewById(R.id.cell111);
		TextView cmpincemin = (TextView) findViewById(R.id.cell121);
		TextView cmpinceminhr = (TextView) findViewById(R.id.cell122);
		TextView cmpincemax = (TextView) findViewById(R.id.cell131);
		
		europincemin.setText(decimalFormat.format(1.2*d0));
		cmpincemin.setText(decimalFormat.format(1.5*d0));
		cmpinceminhr.setText(decimalFormat.format(1.5*d0));
		cmpincemax.setText(decimalFormat.format(2.5*d0));
		
		TextView europasmin = (TextView) findViewById(R.id.cell211);
		TextView europasminhr = (TextView) findViewById(R.id.cell212);
		TextView cmpasmin = (TextView) findViewById(R.id.cell221);
		TextView cmpasminhr = (TextView) findViewById(R.id.cell222);
		TextView cmpasmax = (TextView) findViewById(R.id.cell231);
		
		europasmin.setText(decimalFormat.format(2.2*d0));
		europasminhr.setText(decimalFormat.format(1.5*d0));
		cmpasmin.setText(decimalFormat.format(3*d0));
		cmpasminhr.setText(decimalFormat.format(3*d0));
		cmpasmax.setText(decimalFormat.format(10*d0));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tableau, menu);
		return true;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		EditText inputD0 = (EditText) findViewById(R.id.inputD0);
		outState.putFloat(stateD0, Float.parseFloat(inputD0.getText().toString()));
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if(savedInstanceState.getFloat(stateD0) != 0 )	
			updateD0(savedInstanceState.getFloat(stateD0));
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	
	

}
