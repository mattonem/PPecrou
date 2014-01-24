package biz.maxmattone.ppecrou;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class TableauActivity extends Activity {

	private DecimalFormat decimalFormat;
	private static final String STATE_D0 = "D0";
	private static final String STATE_T = "T";

	private ObservableParameter<String> t;
	private ObservableParameter<String> d0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		t = new ObservableParameter<String>();
		t.setAttr("");
		d0 = new ObservableParameter<String>();
		d0.setAttr("");
		setContentView(R.layout.activity_tableau);
		decimalFormat = new DecimalFormat("#.###");
		EditText inputD0 = (EditText) findViewById(R.id.inputD0);
		EditText inputT = (EditText) findViewById(R.id.inputT);
		///////////////////////////////////////////////////////////////////
		Formule formule1 = new Formule("", 1.2f, "d0", "", decimalFormat);
		formule1.addObserver((TextViewObserver) findViewById(R.id.cell111));
		d0.addObserver(formule1);

		Formule formule2 = new Formule("", 1.5f, "d0", "", decimalFormat);
		formule2.addObserver((TextViewObserver) findViewById(R.id.cell121));
		d0.addObserver(formule2);
		
		Formule formule3 = new Formule("", 1.5f, "d0", "", decimalFormat);
		formule3.addObserver((TextViewObserver) findViewById(R.id.cell122));
		d0.addObserver(formule3);
		
		Formule formule4 = new Formule("", 2.5f, "d0", "", decimalFormat);
		formule4.addObserver((TextViewObserver) findViewById(R.id.cell131));
		d0.addObserver(formule4);
		///////////////////////////////////////////////////////////////////
		Formule formule5 = new Formule("", 2.5f, "d0", "", decimalFormat);
		formule5.addObserver((TextViewObserver) findViewById(R.id.cell211));
		d0.addObserver(formule5);
		
		Formule formule6 = new Formule("", 1.5f, "d0", "", decimalFormat);
		formule6.addObserver((TextViewObserver) findViewById(R.id.cell212));
		d0.addObserver(formule6);
		
		Formule formule7 = new Formule("", 3f, "d0", "", decimalFormat);
		formule7.addObserver((TextViewObserver) findViewById(R.id.cell221));
		d0.addObserver(formule7);
		
		Formule formule8 = new Formule("", 3f, "d0", "", decimalFormat);
		formule8.addObserver((TextViewObserver) findViewById(R.id.cell222));
		d0.addObserver(formule8);
		
		Formule formule9 = new Formule("", 10f, "d0", "", decimalFormat);
		formule9.addObserver((TextViewObserver) findViewById(R.id.cell231));
		d0.addObserver(formule9);
		///////////////////////////////////////////////////////////////////
		Formule formule10 = new Formule("", 6f, "t", "", decimalFormat);
		formule10.addObserver((TextViewObserver) findViewById(R.id.cell132));
		t.addObserver(formule10);
		
		Formule formule11 = new Formule("", 4f, "t", " ou 40", decimalFormat);
		formule11.addObserver((TextViewObserver) findViewById(R.id.cell141));
		t.addObserver(formule11);
		
		Formule formule12 = new Formule("", 4f, "t", " ou 125", decimalFormat);
		formule12.addObserver((TextViewObserver) findViewById(R.id.cell142));
		t.addObserver(formule12);
		///////////////////////////////////////////////////////////////////
		Formule formule13 = new Formule("", 15f, "t", "", decimalFormat);
		formule13.addObserver((TextViewObserver) findViewById(R.id.cell232));
		t.addObserver(formule13);
		
		Formule formule14 = new Formule("", 14f, "t", " ou 200", decimalFormat);
		formule14.addObserver((TextViewObserver) findViewById(R.id.cell241));
		t.addObserver(formule14);
		
		Formule formule15 = new Formule("", 4f, "t", " ou 200", decimalFormat);
		formule15.addObserver((TextViewObserver) findViewById(R.id.cell242));
		t.addObserver(formule15);
		
		

		inputT.setOnEditorActionListener(new TextView.OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				t.setAttr(v.getText().toString());
				return false;
			}
		});

		inputD0.setOnEditorActionListener(new TextView.OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				d0.setAttr(v.getText().toString());

				return false;
			}
		});
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
		EditText inputT = (EditText) findViewById(R.id.inputT);
		Log.d("test", "msg:" + inputD0.getText().toString() + "stop"
				+ inputD0.getText().toString().matches(""));
		Log.d("test", "msg:" + inputD0.getText().toString() + "stop"
				+ inputD0.getText().toString().matches(""));

		if (!inputD0.getText().toString().matches(""))
			outState.putFloat(STATE_D0,
					Float.parseFloat(inputD0.getText().toString()));
		if (!inputT.getText().toString().matches(""))
			outState.putFloat(STATE_T,
					Float.parseFloat(inputT.getText().toString()));
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.getFloat(STATE_D0) != 0)
			updateD0(savedInstanceState.getFloat(STATE_D0));
		if (savedInstanceState.getFloat(STATE_T) != 0)
			updateT(savedInstanceState.getFloat(STATE_T));
		super.onRestoreInstanceState(savedInstanceState);
	}

	public void updateD0(float d0) {
		TextView europincemin = (TextView) findViewById(R.id.cell111);
		TextView cmpincemin = (TextView) findViewById(R.id.cell121);
		TextView cmpinceminhr = (TextView) findViewById(R.id.cell122);
		TextView cmpincemax = (TextView) findViewById(R.id.cell131);

		europincemin.setText(decimalFormat.format(1.2 * d0));
		cmpincemin.setText(decimalFormat.format(1.5 * d0));
		cmpinceminhr.setText(decimalFormat.format(1.5 * d0));
		cmpincemax.setText(decimalFormat.format(2.5 * d0));

		TextView europasmin = (TextView) findViewById(R.id.cell211);
		TextView europasminhr = (TextView) findViewById(R.id.cell212);
		TextView cmpasmin = (TextView) findViewById(R.id.cell221);
		TextView cmpasminhr = (TextView) findViewById(R.id.cell222);
		TextView cmpasmax = (TextView) findViewById(R.id.cell231);

		europasmin.setText(decimalFormat.format(2.2 * d0));
		europasminhr.setText(decimalFormat.format(1.5 * d0));
		cmpasmin.setText(decimalFormat.format(3 * d0));
		cmpasminhr.setText(decimalFormat.format(3 * d0));
		cmpasmax.setText(decimalFormat.format(10 * d0));
	}

	private void updateT(float t) {
		TextView cmpincemaxhr = (TextView) findViewById(R.id.cell132);
		TextView europincemax = (TextView) findViewById(R.id.cell141);
		TextView europincemaxhr = (TextView) findViewById(R.id.cell142);

		cmpincemaxhr.setText(decimalFormat.format(6 * t));
		europincemax.setText(decimalFormat.format(4 * t + 40));
		europincemaxhr.setText(decimalFormat.format(8 * t) + " ou 125");

		TextView cmpasmaxhr = (TextView) findViewById(R.id.cell232);
		TextView europasmax = (TextView) findViewById(R.id.cell241);
		TextView europasmaxhr = (TextView) findViewById(R.id.cell242);

		cmpasmaxhr.setText(decimalFormat.format(15 * t));
		europasmax.setText(decimalFormat.format(14 * t) + " ou 200");
		europasmaxhr.setText(decimalFormat.format(4 * t) + " ou 200");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		EditText inputD0;
		EditText inputT;
		switch (item.getItemId()) {
		case R.id.reset_action:
			inputD0 = (EditText) findViewById(R.id.inputD0);
			inputT = (EditText) findViewById(R.id.inputT);
			inputD0.setText(new String());
			inputT.setText(new String());
			recreate();
			break;
		case R.id.actualise_action:
			inputD0 = (EditText) findViewById(R.id.inputD0);
			inputT = (EditText) findViewById(R.id.inputT);

			if (!inputD0.getText().toString().matches(""))
				updateD0(Float.parseFloat(inputD0.getText().toString()));
			if (!inputT.getText().toString().matches(""))
				updateT(Float.parseFloat(inputT.getText().toString()));
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}