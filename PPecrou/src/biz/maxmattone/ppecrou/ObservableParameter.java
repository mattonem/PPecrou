package biz.maxmattone.ppecrou;

import java.util.Observable;
import java.util.Observer;

public class ObservableParameter<T> extends Observable {
	private T attr;

	public T getAttr() {
		return attr;
	}

	public void setAttr(T attr) {
		this.attr = attr;
		setChanged();
		notifyObservers(attr);
	}
	
	@Override
	public void addObserver(Observer observer) {
		observer.update(this, attr);
		super.addObserver(observer);
	}
	
	
}
