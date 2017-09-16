package map.doubledouble;

public class JDKDoubleDoubleMapTest extends DoubleDoubleMapTest {

	@Override
	protected IDoubleDoubleMap makeMap(int size) {
		return new JDKDoubleMap(size);
	}

}
