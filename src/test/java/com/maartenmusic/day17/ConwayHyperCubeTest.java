package com.maartenmusic.day17;

import com.maartenmusic.util.Coordinates3D;
import com.maartenmusic.util.Coordinates4D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConwayHyperCubeTest {

    @Test
    void findNeighbours() {
        //given
        Cube cube = new ConwayHyperCube(new Coordinates4D(0,0,0, 0));
        Cube cube2 = new ConwayHyperCube(new Coordinates4D(-1, 1, 1, -1));
        Cube cube3 = new ConwayHyperCube(new Coordinates4D(1, -1, -1, 1));
        //when
        cube.findNeighbours();
        //then
        cube.getNeighbours().forEach(System.out::println);
        assertFalse(cube.getNeighbours().contains(cube));
        assertEquals(80, cube.getNeighbours().size());
        assertTrue(cube.getNeighbours().contains(cube2));
        assertTrue(cube.getNeighbours().contains(cube3));
    }

}