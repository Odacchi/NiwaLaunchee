package tokyo.leach.niwalaunchee.Listener.Key;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tomi on 2016/09/06.
 */
public class SpecialKeyPressedSubject {
	private List<SpecialKeyPressedObserver> observers = new ArrayList<SpecialKeyPressedObserver>();

	public void addObserver(SpecialKeyPressedObserver o) {
		observers.add(o);
	}

	public void removeObserver(SpecialKeyPressedObserver o) {
		observers.remove(o);
	}

	public void notifyObservers(){
		Iterator<SpecialKeyPressedObserver> it = observers.iterator();
		while(it.hasNext()){
			it.next().specialKeyPressed();
		}
	}
}
