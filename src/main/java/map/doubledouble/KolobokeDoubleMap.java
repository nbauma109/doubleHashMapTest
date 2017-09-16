package map.doubledouble;

import com.koloboke.collect.map.hash.HashDoubleDoubleMap;
import com.koloboke.collect.map.hash.HashDoubleDoubleMaps;

public class KolobokeDoubleMap implements IDoubleDoubleMap {

	private HashDoubleDoubleMap map;

	private Double defaultValue;

	public KolobokeDoubleMap(int size) {
		map = HashDoubleDoubleMaps.newMutableMap(size);
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
