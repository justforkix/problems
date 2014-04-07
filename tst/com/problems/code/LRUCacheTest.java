package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.LRUCache;

@RunWith(JUnit4.class)
public class LRUCacheTest {

	@Test
	public void testLRUCache() {
		
		int capacity = 5;
		LRUCache cache = new LRUCache(capacity);
		
		cache.set(1,11);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(1));

		cache.set(2,12);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(2));

		cache.set(3,13);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(3));

		cache.set(4,14);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(4));

    	cache.set(5,15);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(5));

		// cache.toString();
		assertThat("test", cache.size(), equalTo(5));
		
		cache.get(3);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(3));
		
		cache.get(5);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(5));
		
		cache.set(2, 22);
		assertThat("test", cache.getLRUKey(), equalTo(1));
		assertThat("test", cache.getMRUKey(), equalTo(2));
		
		cache.set(6,16);
		assertThat("test", cache.getLRUKey(), equalTo(4));
		assertThat("test", cache.getMRUKey(), equalTo(6));
		
		cache.set(7,17);
		assertThat("test", cache.getLRUKey(), equalTo(3));
		assertThat("test", cache.getMRUKey(), equalTo(7));

		
		
	}

}
