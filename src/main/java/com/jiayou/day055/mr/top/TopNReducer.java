package com.jiayou.day055.mr.top;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Create by fz on 2020/4/14
 */
public class TopNReducer extends Reducer<FlowBean,Text,Text,FlowBean> {
    private TreeMap<FlowBean, Text> flowMap = new TreeMap<>();




    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for (Text value : values) {
            FlowBean flowBean = new FlowBean(key.getUpFlow(), key.getDownFlow());
            flowMap.put(flowBean,new Text(value));

            //若TreeMap中超过10条数据，则删除最小的，即最后的
            if (flowMap.size() > 10) {
                flowMap.remove(flowMap.lastKey());
            }
        }


    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        Iterator<FlowBean> iterator = flowMap.keySet().iterator();
        //遍历
        while (iterator.hasNext()) {
            FlowBean bean = iterator.next();
            context.write(flowMap.get(bean),bean);
        }
    }
}
