package map.doubledouble;

public class FastUtilDoubleDoubleMapTest extends DoubleDoubleMapTest {

	@Override
	protected IDoubleDoubleMap makeMap(int size) {
		return new FastUtilDoubleMap(size);
	}

}
