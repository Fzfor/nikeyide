package com.jiayou.day055.mr.top;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Create by fz on 2020/4/14
 */
public class TopNMapper extends Mapper<LongWritable,Text,FlowBean,Text> {
    //定义一个Treemap作为存储数据的容器（天然按key排序）
    private TreeMap<FlowBean, Text> flowBeanMap = new TreeMap<>();

    private FlowBean kFlowBean;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        kFlowBean = new FlowBean();

        String line = value.toString();
        String[] splits = line.split("\t");
        Text v = new Text(splits[0]);

        kFlowBean.setUpFlow(Long.parseLong(splits[1]));
        kFlowBean.setDownFlow(Long.parseLong(splits[2]));
        kFlowBean.setSumFlow(Long.parseLong(splits[3]));
        //放入treemap中
        flowBeanMap.put(kFlowBean, v);

        //若TreeMap中超过10条数据，则删除最小的，即最后的
        if (flowBeanMap.size() > 10) {
            flowBeanMap.remove(flowBeanMap.lastKey());
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        //遍历TreeMap，将其中的数据提交
        Iterator<FlowBean> iterator = flowBeanMap.keySet().iterator();
        while (iterator.hasNext()) {
            FlowBean bean = iterator.next();
            //提交
            context.write(bean,flowBeanMap.get(bean));
        }
    }
}
