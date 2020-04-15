package com.jiayou.day055.mr.commonFriends;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.io.IOException;

/**
 * Create by fz on 2020/4/15
 */
public class TwoShareFriendsDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(TwoShareFriendsDriver.class);
        job.setMapperClass(TwoShareFriendsMapper.class);
        job.setReducerClass(TwoShareFriendsReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path("src/output1"));
        FileOutputFormat.setOutputPath(job, new Path("src/output2"));

        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}
