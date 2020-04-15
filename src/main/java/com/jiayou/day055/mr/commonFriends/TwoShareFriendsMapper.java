package com.jiayou.day055.mr.commonFriends;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;


/**
 * Create by fz on 2020/4/15
 */
public class TwoShareFriendsMapper extends Mapper<LongWritable,Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] splits = line.split("\t");

        String friend = splits[0];

        String[] persons = splits[1].split(",");
        Arrays.sort(persons);

        for (int i = 0; i < persons.length; i++) {
            for (int j = i+1; j < persons.length; j++) {
                String k = persons[i] + "<-->" + persons[j];
                context.write(new Text(k),new Text(friend));
            }
        }
    }
}
