package com.metrics.github.domain;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EqualsHashTest {

    User sameUserOne = new User(1L);
    User sameUserTwo = new User(1L);
    User differentUser = new User(0L);

    /* test equals */

    @Test
    public void testEquals() {
        assertTrue("Class is equal to itself.", sameUserOne.equals(sameUserOne));
        assertFalse("Passing incompatible object to equals should return false", sameUserOne.equals("blah-blah"));
        assertFalse("Passing null to equals should return false", sameUserOne.equals(null));
        assertTrue("Reflexive test fail sameUserOne,sameUserTwo", sameUserOne.equals(sameUserTwo));
        assertTrue("Symmetric test fail sameUserTwo", sameUserTwo.equals(sameUserOne));
    }

    /* test hashcode */

    @Test
    public void twoEqualsObjectsReturnSameNumber() {
        int userOneHashcode = sameUserOne.hashCode();
        int userTwoHashcode = sameUserTwo.hashCode();
        assertEquals("Two equal objects should return same number", userOneHashcode, userTwoHashcode);
    }

    @Test
    public void twoUnEqualObjectsReturnDifferentNumber() {
        int userOneHashcode = sameUserOne.hashCode();
        int differentUserHashcode = differentUser.hashCode();
        assertTrue("Two unequal objects should return different number", !(userOneHashcode == differentUserHashcode));
    }

}