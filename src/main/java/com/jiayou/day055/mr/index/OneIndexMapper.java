package com.jiayou.day055.mr.index;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * Create by fz on 2020/4/10
 */
public class OneIndexMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private String name;

    private Text k = new Text();
    private IntWritable v = new IntWritable();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit split = (FileSplit) context.getInputSplit();
        name = split.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] splits = line.split(" ");

        for (String word : splits) {
            k.set(word + "--" + name);
            v.set(1);
            context.write(k,v);
        }
    }
}
