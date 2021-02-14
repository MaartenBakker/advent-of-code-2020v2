package com.maartenmusic.day17;

import com.maartenmusic.util.Coordinates;
import com.maartenmusic.util.Coordinates3D;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConwayCubeTest {

    @Test
    void findNeighbours() {
        //given
        ConwayCube cube = new ConwayCube(new Coordinates3D(0,0,0));
        ConwayCube cube2 = new ConwayCube(new Coordinates3D(-1, 1, 1));
        ConwayCube cube3 = new ConwayCube(new Coordinates3D(1, -1, -1));
        //when
        cube.findNeighbours();
        //then
        assertFalse(cube.getNeighbours().contains(cube));
        assertEquals(26, cube.getNeighbours().size());
        assertTrue(cube.getNeighbours().contains(cube2));
        assertTrue(cube.getNeighbours().contains(cube3));
    }
}