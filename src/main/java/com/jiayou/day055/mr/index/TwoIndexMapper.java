package com.jiayou.day055.mr.index;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.awt.*;
import java.io.IOException;

/**
 * Create by fz on 2020/4/10
 */
public class TwoIndexMapper extends Mapper<LongWritable,Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] splits = line.split("--");
        Text k = new Text(splits[0]);
        Text v = new Text(splits[1]);
        context.write(k,v);
    }
}
