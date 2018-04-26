package io.jenkins.plugins.analysis.warnings;

import org.junit.jupiter.api.Test;

import static edu.hm.hafner.analysis.assertj.Assertions.*;

/**
 * Tests the class {@link PmdMessages}.
 *
 * @author Ullrich Hafner
 */
class PmdMessagesTest {
    /**
     * Verifies that the PMD messages could be correctly read.
     */
    @Test
    public void shouldHaveAllMessage() {
        PmdMessages messages = new PmdMessages();
        assertThat(messages.initialize()).as("Wrong number of rulesets found").isEqualTo(7);

        assertThat(messages.getMessage("Error Prone", "NullAssignment"))
                .isEqualTo("\n"
                + "Assigning a \"null\" to a variable (outside of its declaration) is usually bad form.  Sometimes, this type\n"
                + "of assignment is an indication that the programmer doesn't completely understand what is going on in the code.\n"
                + "\n"
                + "NOTE: This sort of assignment may used in some cases to dereference objects and encourage garbage collection.\n"
                + "        <pre>\n"
                + " \n"
                + "public void bar() {\n"
                + "  Object x = null; // this is OK\n"
                + "  x = new Object();\n"
                + "     // big, complex piece of code here\n"
                + "  x = null; // this is not required\n"
                + "     // big, complex piece of code here\n"
                + "}\n"
                + "\n"
                + "        </pre>");
    }
}