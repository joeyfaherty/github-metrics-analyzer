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

    /**
     * Oracles definition: The equals method implements an equivalence relation on non-null object
     * references:
     *
     * It is reflexive: for any non-null reference value x, x.equals(x) should return true.
     * It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only
     * if y.equals(x) returns true.
     * It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true
     * and y.equals(z) returns true, then x.equals(z) should return true.
     * It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y)
     * consistently return true or consistently return false, provided no information used in equals
     * comparisons on the objects is modified.
     * For any non-null reference value x, x.equals(null) should return false.
     */
    @Test
    public void testEquals() {
        assertTrue("Class is equal to itself.", sameUserOne.equals(sameUserOne));
        assertFalse("Passing incompatible object to equals should return false", sameUserOne.equals("blah-blah"));
        assertFalse("Passing null to equals should return false", sameUserOne.equals(null));
        assertTrue("Reflexive test fail sameUserOne,sameUserTwo", sameUserOne.equals(sameUserTwo));
        assertTrue("Symmetric test fail sameUserTwo", sameUserTwo.equals(sameUserOne));
    }

    /* test hashcode */

    /**
     * Whenever it is invoked on the same object more than once during an execution of a Java
     * application, the hashCode method must consistently return the same integer, provided no
     * information used in equals comparisons on the object is modified. This integer need not
     * remain consistent from one execution of an application to another execution of the same
     * application. If two objects are equal according to the equals(Object) method, then calling
     * the hashCode method on each of the two objects must produce the same integer result. It is
     * not required that if two objects are unequal according to the equals(java.lang.Object)
     * method, then calling the hashCode method on each of the two objects must produce distinct
     * integer results. However, the programmer should be aware that producing distinct integer
     * results for unequal objects may improve the performance of hash tables.
     */
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