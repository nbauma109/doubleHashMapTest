/*
 * (C) Copyright 2015 Mikhail Vorontsov ( http://java-performance.info/ ) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *      Mikhail Vorontsov
 */

package map.doubledouble;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import junit.framework.TestCase;

public abstract class DoubleDoubleMapTest extends TestCase {

	private final int SIZE = 5000000;

	protected abstract IDoubleDoubleMap makeMap(int size);

	/**
	 * Add keys 0-SIZE to the map
	 */
	public void testPut() {
		final IDoubleDoubleMap map = makeMap(100);
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(map.getDefaultValue(), map.put(i, i));

			assertTrue(i + 1 == map.size());
			assertEquals(i, map.get(i));
		}
		// now check the final state
		assertEquals(SIZE, map.size());
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(i, map.get(i));
		}
	}

	/**
	 * Add a series of negative keys to the map
	 */
	public void testPutNegative() {
		final IDoubleDoubleMap map = makeMap(100);
		for (double i = 0; i < SIZE; ++i) {
			map.put(-i, -i);
			assertTrue(i + 1 == map.size());
			assertEquals(-i, map.get(-i));
		}
		// now check the final state
		assertEquals(SIZE, map.size());
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(-i, map.get(-i));
		}
	}

	/**
	 * Add a set of keys to the map. Then add it again to test update
	 * operations.
	 */
	public void testPutThenUpdate() {
		final IDoubleDoubleMap map = makeMap(100);
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(map.getDefaultValue(), map.put(i, i));
			assertTrue(i + 1 == map.size());
			assertEquals(i, map.get(i));
		}
		// now check the initial state
		assertEquals(SIZE, map.size());
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(i, map.get(i));
		}

		// now try to update all keys
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(i, map.put(i, i + 1));
			assertEquals(SIZE, map.size());
			assertEquals(i + 1, map.get(i));
		}
		// and check the final state
		for (double i = 0; i < SIZE; ++i) {
			assertEquals(i + 1, map.get(i));
		}
	}

	/**
	 * Add random keys to the map. We use random seeds for the random generator
	 * (each test run is unique), so we log the seeds used to initialize
	 * Random-s.
	 */
	public void testPutRandom() {
		final int seed = ThreadLocalRandom.current().nextInt();
		final Random r = new Random(seed);
		final Set<Double> set = new LinkedHashSet<>(SIZE);
		final double[] vals = new double[SIZE];
		while (set.size() < SIZE) {
			set.add(r.nextDouble());
		}
		int i = 0;
		for (final Double v : set) {
			vals[i++] = v;
		}
		final IDoubleDoubleMap map = makeMap(100);
		for (i = 0; i < vals.length; ++i) {
			assertEquals(map.getDefaultValue(), map.put(vals[i], vals[i]));
			assertTrue(i + 1 == map.size());
			assertEquals(vals[i], map.get(vals[i]));
		}
		// now check the final state
		assertEquals(SIZE, map.size());
		for (i = 0; i < vals.length; ++i) {
			assertEquals(vals[i], map.get(vals[i]));
		}
	}

	/**
	 * Interleaved put and remove operations - we remove half of added entries
	 */
	public void testRemove() {
		final IDoubleDoubleMap map = makeMap(100);
		double addCnt = 0;
		double removeCnt = 0;
		for (int i = 0; i < SIZE; ++i) {
			assertEquals(map.getDefaultValue(), map.put(addCnt, addCnt));
			assertTrue(i + 1 == map.size());
			addCnt++;

			assertEquals(map.getDefaultValue(), map.put(addCnt, addCnt));
			assertEquals(i + 2, map.size()); // map grows by one element on each
												// iteration
			addCnt++;

			assertEquals(removeCnt, map.remove(removeCnt));
			removeCnt++;

			assertTrue(i + 1 == map.size()); // map grows by one element on each
												// iteration
		}

		assertEquals(SIZE, map.size());
		for (double i = removeCnt; i < addCnt; ++i) {
			assertEquals(i, map.get(i));
		}
	}

	public void testRandomRemove() {
		final Random r = new Random(1);
		final double[] values = new double[SIZE];
		Set<Double> ks = new LinkedHashSet<>(SIZE);
		while (ks.size() < SIZE) {
			ks.add(r.nextDouble());
		}
		final Double[] keys = ks.toArray(new Double[SIZE]);
		ks = null;

		assertEquals(SIZE, keys.length);

		for (int i = 0; i < SIZE; ++i) {
			values[i] = r.nextDouble();
		}

		IDoubleDoubleMap m = makeMap(100);
		int add = 0, remove = 0;
		while (add < SIZE) {
			assertEquals(m.getDefaultValue(), m.put(keys[add], values[add]));
			++add;
			assertEquals(m.getDefaultValue(), m.put(keys[add], values[add]));
			++add;

			assertEquals(values[remove], m.remove(keys[remove]));
			remove++;

			assertEquals(remove, m.size());
		}

		assertEquals(SIZE / 2, m.size());

		for (int i = 0; i < SIZE / 2; ++i) {
			assertEquals(m.getDefaultValue(), m.get(keys[i]));
		}
		for (int i = SIZE / 2; i < SIZE; ++i) {
			assertEquals(values[i], m.get(keys[i]));
		}
	}

}