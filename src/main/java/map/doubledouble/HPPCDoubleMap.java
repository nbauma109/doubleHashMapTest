package map.doubledouble;

import com.carrotsearch.hppc.DoubleDoubleHashMap;

public class HPPCDoubleMap implements IDoubleDoubleMap {

	private DoubleDoubleHashMap map;

	private Double defaultValue;

	public HPPCDoubleMap(int size) {
		map = new DoubleDoubleHashMap(size);
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
