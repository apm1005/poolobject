/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import java.util.Vector;
import java.util.logging.Logger;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {
	
	private Reusable r1, r2, r3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.r1 = new Reusable();
		this.r2 = new Reusable();
		this.r3 = new Reusable();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool pool = ReusablePool.getInstance();
		assertNotNull(pool);
		assertEquals(pool, ReusablePool.getInstance());
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		ReusablePool pool = ReusablePool.getInstance();
		try {
			pool.releaseReusable(this.r1);
			pool.releaseReusable(this.r2);
			pool.releaseReusable(this.r3);
		} catch (DuplicatedInstanceException e) {
			fail(e.toString());
		}
		try {
			pool.releaseReusable(this.r1);
			fail("Released r1 twice");
		} catch (DuplicatedInstanceException ignored) {}
	}

}
