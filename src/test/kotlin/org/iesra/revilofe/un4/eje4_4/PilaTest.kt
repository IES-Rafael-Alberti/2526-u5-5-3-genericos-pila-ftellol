package org.iesra.revilofe.un4.eje4_4

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PilaTest {
    @Test
    fun pushPop_isLifo() {
        val stack = Pila<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
        assertTrue(stack.isEmpty())
        assertEquals(0, stack.size)
    }

    @Test
    fun peek_doesNotRemove() {
        val stack = Pila<String>()
        stack.push("a")
        stack.push("b")

        assertEquals("b", stack.peek())
        assertEquals(2, stack.size)
        assertFalse(stack.isEmpty())
    }

    @Test
    fun pop_empty_throws() {
        val stack = Pila<Int>()
        assertFailsWith<NoSuchElementException> { stack.pop() }
    }

    @Test
    fun iterator_goesFromTopToBottom() {
        val stack = Pila<String>()
        stack.push("one")
        stack.push("two")
        stack.push("three")

        assertEquals(listOf("three", "two", "one"), stack.toList())
    }
}

class ReverseTest {
    @Test
    fun reverse_matchesExpectedExample() {
        val numbers = listOf("one", "two", "three", "four")
        val numbersRev = reverse(numbers)
        assertEquals(listOf("four", "three", "two", "one"), numbersRev)
    }

    @Test
    fun reverse_worksWithInts() {
        assertEquals(listOf(3, 2, 1), reverse(listOf(1, 2, 3)))
    }
}

