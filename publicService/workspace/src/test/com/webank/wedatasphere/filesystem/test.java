package com.webank.wedatasphere.filesystem;
import com.webank.wedatasphere.linkis.common.io.FsPath;
import com.webank.wedatasphere.linkis.filesystem.dao.ResourceVersionMapper;
import com.webank.wedatasphere.linkis.filesystem.entity.ResourceVersion;
import com.webank.wedatasphere.linkis.filesystem.exception.WorkSpaceException;
import com.webank.wedatasphere.linkis.filesystem.util.UriFileHdfsUtil;
import com.webank.wedatasphere.linkis.storage.utils.StorageUtils;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.glassfish.jersey.media.multipart.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class test {


    @Autowired
    ResourceVersionMapper resourceVersionMapper;


    private void fsValidate(FileSystem fileSystem) throws WorkSpaceException {
        if (fileSystem == null) {
            throw new WorkSpaceException("The user has obtained the filesystem for more than 2s. Please contact the administrator.（用户获取filesystem的时间超过2s，请联系管理员）");
        }
    }

    @Test
    public void test() throws WorkSpaceException, IOException {
        String path = "hdfs://hdfs:///tmp/linkis/hadoop/test/ds";
        String version = "5";
        String modelName = "modelName";
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
        FormDataContentDisposition.FormDataContentDispositionBuilder caozifuBuilder = FormDataContentDisposition.name("caozifu");
        caozifuBuilder.fileName("caozifu7");
        caozifuBuilder.size(30);
        FormDataContentDisposition formDataContentDisposition = caozifuBuilder.build();
        formDataMultiPart.setContentDisposition(formDataContentDisposition);
        formDataMultiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
        FormDataBodyPart formDataBodyPart = new FormDataBodyPart(formDataContentDisposition, "caozifu");


        formDataBodyPart.setValue("hahahahahahahahahahaaahahahahah");




        //获取文件名
        String fileName = formDataBodyPart.getContentDisposition().getFileName();
        //获取即将要创建的的文件目录
        String filePath = path + "/" + modelName + "/" + fileName + "/" + version;
        if (StringUtils.isEmpty(path)) {
            throw new WorkSpaceException("Path(路径)：" + path + "Is empty!(为空！)");
        }
        //获取当前路径的fsPath
        FsPath fsPath = new FsPath(filePath);
        System.out.println("获得fspath" + fsPath.getPath());
        org.apache.hadoop.fs.FileSystem fileSystem = UriFileHdfsUtil.getFileSystem();
        fsValidate(fileSystem);


        Path dirPath = new Path(fsPath.getPath());
        Boolean aBoolean = dirIsExist(fileSystem, dirPath);
        if (!aBoolean){
            fileSystem.mkdirs(dirPath);
        }
        //在指定目录创建文件
        filePath = path + "/" + modelName + "/" + fileName + "/" + version + "/" + fileName;

        fsPath = new FsPath(filePath);
        //创建新的空白文件
        FSDataOutputStream out = fileSystem.create(new org.apache.hadoop.fs.Path(fsPath.getPath()));
        //将脚本文件内容写入空白文件中
        String is = formDataBodyPart.getValue();
        out.writeChars(is);
        StorageUtils.close(out, null, null);
    }

    private Boolean dirIsExist(FileSystem fileSystem,Path path){
        try {
            boolean exists = fileSystem.exists(path);
            return exists;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Integer FindMax(FileSystem fileSystem,Path path,String version){
        //找到同一个文件下的最高的版本
        try {
            System.out.println("----------------------------------------");

            FileStatus[] fileStatuses = fileSystem.listStatus(path);
            List<String> list = new ArrayList<>();
            for (FileStatus fileStatus : fileStatuses) {
                //将所有的名称都塞入list内
                list.add(fileStatus.getPath().getName());
            }
            List<String> collect = list.stream().sorted((version1, version2) -> Integer.compare(Integer.parseInt(version2), Integer.parseInt(version1))).collect(Collectors.toList());
            collect.forEach(System.out::println);
            System.out.println("----------------------------------------");
            return Integer.parseInt(collect.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Test
    public void test2(){
        org.apache.hadoop.fs.FileSystem fileSystem = UriFileHdfsUtil.getFileSystem();
        try {
            FSDataInputStream open = fileSystem.open(new Path("/tmp/linkis/hadoop/test/ds/modelName/caozifu6/5/caozifu6"));
            IOUtils.copyBytes(open,System.out,1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        String path = "/tmp/linkis/hadoop/test/ds";

        org.apache.hadoop.fs.FileSystem fileSystem = UriFileHdfsUtil.getFileSystem();

        String modelName = "modelName";
        String fileName = "caozifu7";
        FindMax(fileSystem,new Path(path + "/" + modelName + "/" + fileName + "/" ),null);

    }

    @Test
    public void test4(){
        ResourceVersion resourceVersion = resourceVersionMapper.selectById(14);
        System.out.println(resourceVersion);
    }


}
