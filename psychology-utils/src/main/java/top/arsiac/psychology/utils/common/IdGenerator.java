package top.arsiac.psychology.utils.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p>id 生成器</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/1
 */
@Configuration
public class IdGenerator {
    private volatile SnowFlake snowFlake;

    /**
     * 主机 id
     * */
    @Value("snow-flake.machine:0")
    private int machineId;

    /**
     * 机房 id
     * */
    @Value("snow-flake.room:0")
    private int roomId;

    public IdGenerator() {}

    public IdGenerator(int machineId, int roomId) {
        this.machineId = machineId;
        this.roomId = roomId;
    }

    /**
     * <p>生成 id</p>
     *
     * @return id
     * */
    public long generate() {
        // 一个服务中只需要一个id生成器
        if (snowFlake == null) {
            synchronized (IdGenerator.class) {
                if (snowFlake == null) {
                    snowFlake = new SnowFlake(roomId, machineId);
                }
            }
        }

        return snowFlake.nextId();
    }
}
