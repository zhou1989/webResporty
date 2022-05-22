package com.zdl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class Test {
    public static void main(String [] args){
        Collection<Object> objects = Collections.synchronizedCollection(Lists.newArrayList());
        File file = new File("D:/data/unitedata/local/ftp_1.csv");
        FileInputStream fileInputStream = IoUtil.toStream(file);
        BufferedReader utf8Reader = IoUtil.getUtf8Reader(fileInputStream);
        Stream<String> lines = utf8Reader.lines();
        lines.parallel().forEach(s ->
                {
                    objects.add(s);
                }
        );

    }
}
