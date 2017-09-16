package map.doubledouble;

import it.unimi.dsi.fastutil.doubles.Double2DoubleOpenHashMap;

public class FastUtilDoubleMap implements IDoubleDoubleMap {

	private Double2DoubleOpenHashMap map;

	private double defaultValue;

	public FastUtilDoubleMap(int size) {
		map = new Double2DoubleOpenHashMap(size);
		defaultValue = map.get(0);
	}

	@Override
	public Double get(double key) {
		return map.get(key);
	}

	@Override
	public Double put(double key, double value) {
		return map.put(key, value);
	}

	@Override
	public Double remove(double key) {
		return map.remove(key);
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
