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
		Double oldVal = map.get(key);
		map.put(key, value);
		return oldVal;
	}

	@Override
	public Double remove(double key) {
		Double oldVal = map.get(key);
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
