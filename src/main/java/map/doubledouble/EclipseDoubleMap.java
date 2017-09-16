package map.doubledouble;

import org.eclipse.collections.impl.map.mutable.primitive.DoubleDoubleHashMap;

public class EclipseDoubleMap implements IDoubleDoubleMap {

	private DoubleDoubleHashMap map;

	private Double defaultValue;

	public EclipseDoubleMap(int size) {
		map = new DoubleDoubleHashMap(size);
		defaultValue = map.get(0);
	}

	@Override
	public Double get(double key) {
		return map.get(key);
	}

	@Override
	public Double put(double key, double value) {
		double oldVal = map.get(key);
		map.put(key, value);
		return oldVal;
	}

	@Override
	public Double remove(double key) {
		double oldVal = map.get(key);
		map.remove(key);
		return oldVal;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Double getDefaultValue() {
		return defaultValue;
	}

}
