package xdu.cloudnative.service.file.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.nio.ch.ThreadPool;

import java.io.*;
import java.util.concurrent.*;

/**
 * @author 邓乐丰@xduTD
 */
@Component
public class IOUtilities {

    /**处理上传文件请求的本地磁盘IO线程池
     * 核心参数：coreThread:1, maxThread:2 * N, keepAliveTime:5min  */
    private static ExecutorService uploadThreadPool;
    /**下载文件本地磁盘IO线程池
     * 核心参数：coreThread:1, maxThread:2 * N, keepAliveTime:5min  */
    private static ExecutorService downloadThreadPool;
    /** 可用CPU数量，与线程池参数设置相关 */
    private static int processorsNumber;

    /**
     * 通过线程池加速本地存储文件的速度
     *
     * @param data 用户上传的文件的数据
     * @param path 文件在服务器上的保存路径
     */
    public static void storeFile(byte[] data, String path) {
        // 对每个请求创建一个任务，然后交给线程池调度。
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // 用户上传的文件
                File file = new File(path);

                boolean flag = true;
                while (flag) {
                    try {
                        // 写文件
                        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                        out.write(data);
                        out.flush();
                        out.close();
                        flag = false;
                    } catch (FileNotFoundException fileNotFoundException) {
                        // 上级目录是否存在？不存在则创建
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        // 创建文件
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Future future = uploadThreadPool.submit(task);

    }


    public static void loadFile(String path) {

    }


    /** 用于配置的静态代码块 */
    static {
        processorsNumber = Runtime.getRuntime().availableProcessors();
        uploadThreadPool = new ThreadPoolExecutor(1, 2 * processorsNumber, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        downloadThreadPool = new ThreadPoolExecutor(1, 2 * processorsNumber, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
}
