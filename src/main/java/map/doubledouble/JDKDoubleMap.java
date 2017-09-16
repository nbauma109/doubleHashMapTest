package map.doubledouble;

import java.util.HashMap;

public class JDKDoubleMap implements IDoubleDoubleMap {

	private HashMap<Double, Double> map;

	private Double defaultValue;

	public JDKDoubleMap(int size) {
		map = new HashMap<>(size);
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
