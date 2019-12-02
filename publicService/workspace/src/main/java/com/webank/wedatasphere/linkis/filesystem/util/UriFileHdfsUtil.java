package com.webank.wedatasphere.linkis.filesystem.util;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UriFileHdfsUtil {
    public  static FileSystem getFileSystem(){
        try {
            FileSystem fileSystem = FileSystem.get(
                    new URI("hdfs://10.194.186.229:8020"),
                    new Configuration(), "bmsoft");
            return fileSystem;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
