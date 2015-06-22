package DesignPattern.Iterator;

import java.util.Iterator;

public interface Menu {
	@SuppressWarnings("rawtypes")
	public Iterator createIterator();
}
