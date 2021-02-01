package top.arsiac.psychology.utils.common;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>雪花算法生成id</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class SnowFlake {
    /*
    * 雪花算法生成全局id
    *
    * long 64 位
    * 1. 第1位为 0(正数)
    * 2. 2-42位为时间戳 (时间戳正好为41位)
    * 3. 43-47位为机房id
    * 4. 48-52位为主机id
    * 5. 53-64位是id序列 (2^12=4096)
    *
    * 0 00000000000000000000000000000000000000000 00000 00000 000000000000
    * */

    /**
     * 时间戳掩码
     * 01111111 11111111 11111111 11111111 11111111 11000000 00000000 00000000
     * */
    public static final long TIME_STAMP_MASK = 9223372036850581504L;

    /**
     * 时间戳左移 22 位
     * */
    public static final int TIME_STAMP_LEFT_SHIFT = 22;

    /**
     * 机房 id 掩码
     * 00000000 00000000 00000000 00000000 00000000 00111110 00000000 00000000
     * */
    public static final long MACHINE_ROOM_MASK = 4063232L;

    /**
     * 机房左移 17 位
     * */
    public static final int MACHINE_ROOM_LEFT_SHIFT = 17;

    /**
     * 主机 id 掩码
     * 00000000 00000000 00000000 00000000 00000000 00000001 11110000 00000000
     * */
    public static final long MACHINE_MASK = 126976L;

    /**
     * 主机左移 12 位
     * */
    public static final int MACHINE_LEFT_SHIFT = 12;

    /**
     * 最大机房 id
     * */
    public static final long MAX_MACHINE_ROOM_ID = 32L;

    /**
     * 最大主机 id
     * */
    public static final long MAX_MACHINE_ID = 32;

    /**
     * 最小机房 id
     * */
    public static final long MIN_MACHINE_ROOM_ID = 0L;

    /**
     * 最小主机 id
     * */
    public static final long MIN_MACHINE_ID = 0L;

    /**
     * 每毫秒最大 id 序列号
     * */
    private static final long MAX_ID_NUMBER = 4095L;

    /**
     * 当前的 id 序列号
     * */
    private final AtomicLong idNumber = new AtomicLong(0);

    /**
     * 主机和机房整合后的id
     * */
    private final long machineAndRoomId;

    /**
     * 记录上一个 id 产生的时间戳
     * */
    private long lastTimeStamp = -1L;

    /**
     * @param machineId 主机 id
     * @param machineRoomId 机房 id
     * */
    public SnowFlake(long machineRoomId, long machineId) {
        if (machineRoomId < MIN_MACHINE_ROOM_ID || MAX_MACHINE_ROOM_ID < machineRoomId) {
            throw new IllegalArgumentException("machineRoomId: " + machineRoomId);
        }
        if (machineId < MIN_MACHINE_ID || MAX_MACHINE_ID < machineId) {
            throw new IllegalArgumentException("machineId: " + machineId);
        }

        this.machineAndRoomId = (machineRoomId << MACHINE_ROOM_LEFT_SHIFT) + (machineId << MACHINE_LEFT_SHIFT);
    }

    /**
     * 获取系统当前时间戳
     *
     * @return 当前时间戳
     * */
    private long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * <p>获取下一个 id</p>
     *
     * @return 获取id
     * */
    public long nextId() {
        // 获取当前时间戳
        long currentTimeStamp = getCurrentTimeStamp();

        // 比较是否和上一个id产生的时间戳相同
        if (currentTimeStamp == lastTimeStamp) {
            // 获取id序列号的当前值
            long lastIdNumber = idNumber.get();

            // 如果已经是 id 序列的最大值则循环等待到下一毫秒再产生id
            if (lastIdNumber == MAX_ID_NUMBER) {
                while (true) {
                    long currentTimeMillis = getCurrentTimeStamp();
                    if (currentTimeStamp != currentTimeMillis) {
                        // 将时间戳更新为新的时间戳
                        currentTimeStamp = currentTimeMillis;
                        // 更新时间戳
                        lastTimeStamp = currentTimeStamp;
                        //将id序列号置零
                        idNumber.set(0L);
                        break;
                    }
                }
            }
            // 如果不相同则说明已经到了下一个毫秒
        } else {
            // 更新时间戳
            lastTimeStamp = currentTimeStamp;
            //将id序列号置零
            idNumber.set(0L);
        }

        // 生成新id
        return currentTimeStamp << TIME_STAMP_LEFT_SHIFT + machineAndRoomId + idNumber.getAndIncrement();
    }

    /**
     * <p>根据 id 计算产生id的时间戳</p>
     *
     * @param id 由雪花算法生成的 id
     * @return 生成该 id 的时间
     * */
    public static long getTimeStampFromId(long id) {
        return (id & TIME_STAMP_MASK) >> TIME_STAMP_LEFT_SHIFT;
    }

    /**
     * <p>根据 id 计算产生id的机房 id</p>
     *
     * @param id 由雪花算法生成的 id
     * @return 生成该 id 的机房 id
     * */
    public static long getMachineRoomIdFromId(long id) {
        return (id & MACHINE_ROOM_MASK) >> MACHINE_ROOM_LEFT_SHIFT;
    }

    /**
     * <p>根据 id 计算产生id的主机 id</p>
     *
     * @param id 由雪花算法生成的 id
     * @return 生成该 id 的主机 id
     * */
    public static long getMachineId(long id) {
        return (id & MACHINE_MASK) >> MACHINE_LEFT_SHIFT;
    }
}
