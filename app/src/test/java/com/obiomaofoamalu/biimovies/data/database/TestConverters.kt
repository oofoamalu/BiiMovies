package com.obiomaofoamalu.biimovies.data.database

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class TestConverters {

    private val mConverter: Converters = Converters()

    @Test
    fun serializeIntegerList() {
        // GIVEN an list of integers
        val integerList = arrayListOf(12, 1, 19)
        // GIVEN an expected string representation of integerList
        val expected = "[12,1,19]"

        // WHEN we serialize integerList
        val result = mConverter.serializeIntegerList(integerList)

        // THEN assert that result is a string
        assertTrue(result is String)
        // THEN assert that result equals expected
        assertEquals(expected, result)
    }

    @Test
    fun deserializeIntegerList() {
        // GIVEN a serialized integer list string
        val serializedIntegerList = "[12,1,19]"

        // WHEN we deserialize
        val result = mConverter.deserializeIntegerList(serializedIntegerList)

        // THEN assert that result is a list of integers
        assertTrue(result is ArrayList<Int>)
        // THEN assert that result contains 3 items
        assertEquals(3, result.size)
        // THEN assert that the first item in result is 12
        assertEquals(12, result[0])
    }

    @Test
    fun serializeEmptyIntegerList() {
        // GIVEN an empty integer list
        val emptyList = ArrayList<Int>()

        // WHEN we serialize emptyList
        val result = mConverter.serializeIntegerList(emptyList)

        // THEN assert that result is a string
        assertTrue(result is String)
    }

    @Test
    fun deserializeEmptyIntegerList() {
        // GIVEN an empty serialized list
        val emptySerializedList = "[]"

        // WHEN we deserialize emptySerializedList
        val result = mConverter.deserializeIntegerList(emptySerializedList)

        // THEN assert that result is empty
        assertTrue(result.isEmpty())
    }

    @Test
    fun serializeStringList() {
        // GIVEN an list of strings
        val stringList = arrayListOf("a", "b", "c")
        // GIVEN an expected string representation of stringList
        val expected = "[\"a\",\"b\",\"c\"]"

        // WHEN we serialize stringList
        val result = mConverter.serializeStringList(stringList)

        // THEN assert that result is a string
        assertTrue(result is String)
        // THEN assert that result equals expected
        assertEquals(expected, result)
    }

    @Test
    fun deserializeStringList() {
        // GIVEN a serialized string list
        val serializedStringList = "[\"a\",\"b\",\"c\"]"

        // WHEN we deserialize
        val result = mConverter.deserializeStringList(serializedStringList)

        // THEN assert that result is a list of strings
        assertTrue(result is ArrayList<String>)
        // THEN assert that result contains 3 items
        assertEquals(3, result.size)
        // THEN assert that the first item in result is a
        assertEquals("a", result[0])
    }

    @Test
    fun serializeEmptyStringList() {
        // GIVEN an empty string list
        val emptyList = ArrayList<String>()

        // WHEN we serialize emptyList
        val result = mConverter.serializeStringList(emptyList)

        // THEN assert that result is a string
        assertTrue(result is String)
    }

    @Test
    fun deserializeEmptyStringList() {
        // GIVEN an empty serialized list
        val emptySerializedList = "[]"

        // WHEN we deserialize emptySerializedList
        val result = mConverter.deserializeStringList(emptySerializedList)

        // THEN assert that result is empty
        assertTrue(result.isEmpty())
    }
}