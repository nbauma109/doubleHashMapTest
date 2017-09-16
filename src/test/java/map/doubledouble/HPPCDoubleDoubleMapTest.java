package map.doubledouble;

public class HPPCDoubleDoubleMapTest extends DoubleDoubleMapTest {

	@Override
	protected IDoubleDoubleMap makeMap(int size) {
		return new HPPCDoubleMap(size);
	}

}
