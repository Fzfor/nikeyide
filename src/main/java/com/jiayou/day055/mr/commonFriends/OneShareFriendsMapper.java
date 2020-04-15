package com.jiayou.day055.mr.commonFriends;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Create by fz on 2020/4/15
 */
public class OneShareFriendsMapper extends Mapper<LongWritable,Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] splits = line.split(":");
        Text person = new Text(splits[0]);

        String[] friends = splits[1].split(",");
        for (String friend : friends) {
            context.write(new Text(friend),person);
        }
    }
}
