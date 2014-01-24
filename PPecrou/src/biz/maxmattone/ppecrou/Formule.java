package biz.maxmattone.ppecrou;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

public class Formule extends Observable implements Observer {

	private String string1;
	private String string2;
	private float param1;
	private String paramName;
	private String stringFinal;
	private DecimalFormat decimalFormat;

	public Formule(String string1, float param1, String paramName, String string2, DecimalFormat decimalFormat) {
		super();
		this.paramName = paramName;
		this.string1 = string1;
		this.string2 = string2;
		this.param1 = param1;
		this.decimalFormat = decimalFormat;
		
	}
	
	@Override
	public String toString() {
		return getStringFinal();
	}

	@Override
	public void update(Observable observable, Object data) {
		try{
			Float valueOf = Float.valueOf(data.toString());
			setStringFinal(string1+decimalFormat.format(param1*valueOf)+string2);
		}catch (NumberFormatException e) {
			setStringFinal(string1+decimalFormat.format(param1)+"."+paramName+string2);
		}
	}

	public String getStringFinal() {
		return stringFinal;
	}

	public void setStringFinal(String stringFinal) {
		this.stringFinal = stringFinal;
		this.setChanged();
		this.notifyObservers();
	}
}
