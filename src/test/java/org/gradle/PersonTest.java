package org.gradle;

import org.junit.Test;

import com.org.projector.ProjectorApp;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        ProjectorApp person = new ProjectorApp();
        //assertEquals("Larry", person.getName());
    }
}
