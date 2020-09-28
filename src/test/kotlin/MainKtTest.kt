import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    internal class MainKtTest {

        @Test
        fun `Test basic case`() {
            assertEquals(1, smth.fibon(1))
        }

        @Test
        fun `Simple test`() {
            assertEquals(5, smth.fibon(5))
        }

        @Test
        fun `Test thirtieth number`() {
            assertEquals(832040, smth.fibon(30))
        }
    }
}