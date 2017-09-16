package map.doubledouble;

public class KolobokeDoubleDoubleMapTest extends DoubleDoubleMapTest {

	@Override
	protected IDoubleDoubleMap makeMap(int size) {
		return new KolobokeDoubleMap(size);
	}

}
