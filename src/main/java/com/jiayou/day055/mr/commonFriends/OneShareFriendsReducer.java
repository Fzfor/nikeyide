package com.jiayou.day055.mr.commonFriends;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Create by fz on 2020/4/15
 */
public class OneShareFriendsReducer extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuffer sb = new StringBuffer();

        for (Text person : values) {
            sb.append(person);
            sb.append(",");
        }

        context.write(key,new Text(sb.toString()));
    }
}
