package biz.maxmattone.ppecrou;
import java.text.DecimalFormat;
import java.util.Observable;



public class FormuleWithAddition extends Formule {

	protected float adding;
	
	public FormuleWithAddition(String string1, float param1, String paramName,
			String string2, DecimalFormat decimalFormat, float adding) {
		super(string1, param1, paramName, string2, decimalFormat);
		this.adding = adding;
	}
	
	@Override
	public void update(Observable observable, Object data) {
		try{
			Float valueOf = Float.valueOf(data.toString());
			setStringFinal(string1+decimalFormat.format(param1*valueOf+adding)+string2);
		}catch (NumberFormatException e) {
			setStringFinal(string1+decimalFormat.format(param1)+"."+paramName+"+"+decimalFormat.format(adding)+string2);
		}
	}

}
