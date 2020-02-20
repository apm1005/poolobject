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
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Rodrigo Díaz García
 * @author Adrián Pineda Miñón
 *
 */
public class ReusablePoolTest {

	private Reusable r1, r2;
	private ReusablePool pool = ReusablePool.getInstance();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		try {
			this.pool.releaseReusable(this.r1);
		} catch (DuplicatedInstanceException ignored) {
		}

		try {
			this.pool.releaseReusable(this.r2);
		} catch (DuplicatedInstanceException ignored) {
		}
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
		try {
			this.r1 = this.pool.acquireReusable();
			this.r2 = this.pool.acquireReusable();
		} catch (NotFreeInstanceException e) {
			fail(e.toString());
		}

		try {
			this.pool.acquireReusable();
			fail("Test failed, r3 shoudn't get a Reusable object");
		} catch (NotFreeInstanceException e) {
		}
	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		try {
			this.r1 = this.pool.acquireReusable();
			this.r2 = this.pool.acquireReusable();
		} catch (NotFreeInstanceException e) {
		}
		try {
			this.pool.releaseReusable(this.r1);
			this.pool.releaseReusable(this.r2);
		} catch (DuplicatedInstanceException e) {
			fail(e.toString());
		}
		try {
			this.pool.releaseReusable(this.r1);
			fail("Released r1 twice");
		} catch (DuplicatedInstanceException ignored) {
		}
	}

}
