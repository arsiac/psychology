package top.arsiac.psychology.utils.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SnowFlakeTest {
    private SnowFlake snowFlake;
    private static final long testId = (1L << SnowFlake.TIME_STAMP_LEFT_SHIFT) +
            (2L << SnowFlake.MACHINE_ROOM_LEFT_SHIFT) +
            (3L << SnowFlake.MACHINE_LEFT_SHIFT);

    @Before
    public void setUp() {
        snowFlake = new SnowFlake(1, 1);
    }

    @Test
    public void testNextId() {
        long id = snowFlake.nextId();
        System.out.println(id);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void testGetTimeStampFromId() {
        long timeStamp = SnowFlake.getTimeStamp(testId);
        Assert.assertEquals(1L, timeStamp);
    }

    @Test
    public void testGetMachineRoomIdFromId() {
        long machineRoomId = SnowFlake.getMachineRoomId(testId);
        Assert.assertEquals(2L, machineRoomId);
    }

    @Test
    public void testGetMachineId() {
        long machineId = SnowFlake.getMachineId(testId);
        Assert.assertEquals(3L, machineId);
    }

    @Test
    public void testGenerateId() {
        long id = SnowFlake.generateId(1, 2, 3, 0);
        Assert.assertEquals(testId, id);
    }
}