package xdu.cloudnative.service.file.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileNameUtilitiesTest {

    @Test
    public void testFileExtend() {
        String fileName = "/mnt/myjfs/test.txt";
        int dot = fileName.lastIndexOf('.');
        String fileExt = fileName.substring(dot);

        Assertions.assertEquals(".txt", fileExt);
    }
}
