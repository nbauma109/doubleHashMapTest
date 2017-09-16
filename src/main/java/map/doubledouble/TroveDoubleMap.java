package map.doubledouble;

import gnu.trove.map.hash.TDoubleDoubleHashMap;

public class TroveDoubleMap implements IDoubleDoubleMap {

	private TDoubleDoubleHashMap map;

	private double defaultValue;

	public TroveDoubleMap(int size) {
		map = new TDoubleDoubleHashMap(size);
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
