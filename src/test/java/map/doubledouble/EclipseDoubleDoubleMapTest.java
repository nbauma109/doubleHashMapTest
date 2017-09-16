package map.doubledouble;

public class EclipseDoubleDoubleMapTest extends DoubleDoubleMapTest {

	@Override
	protected IDoubleDoubleMap makeMap(int size) {
		return new EclipseDoubleMap(size);
	}

}
