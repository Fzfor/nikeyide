package com.jiayou.day055.mr.index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


/**
 * Create by fz on 2020/4/10
 */
public class TwoIndexReducer extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        StringBuffer buffer = new StringBuffer();

        for (Text value : values) {
            String string = value.toString();
            String replace = string.replace("\t", "-->");
            buffer.append(replace + "\t");
        }
        Text v = new Text(buffer.toString());
        context.write(key,v);
    }
}
