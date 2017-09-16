package map.doubledouble;

/**
 * These methods will be implemented by all test maps
 */
public interface IDoubleDoubleMap {

	public Double get(final double key);

	public Double put(final double key, final double value);

	public Double remove(final double key);

	public int size();

	public Double getDefaultValue();
}
