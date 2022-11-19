package eu.ownyourdata.pia.web.utils;


import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipFile;

public class Files {

    public static File toFile(MultipartFile multipart) throws IOException {
        File temp = Files.createTempFile("plugin", "tmp").toFile();
        FileUtils.copyInputStreamToFile(multipart.getInputStream(),temp);
        return temp;
    }

    public static ZipFile toZipFile(MultipartFile multipart) throws IOException {
        return new ZipFile(toFile(multipart));
    }
}
