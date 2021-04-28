package itheima.util;


import itheima.dto.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合工具类
 */
public class XUtils {
    private XUtils() {
    }

    /**
     * 根据页面
     * @param pageNum 当前页
     * @param pageSize 页面数据条数
     * @param list  全部的数据
     * @return
     */
    public static PageInfo getCurrentPageData(int pageNum, int pageSize, List list){
        List data = new ArrayList();
        //集合数据总数量
        int dataSize = list.size();
        //总页数
        int pageCount = dataSize % pageSize == 0 ? dataSize / pageSize : dataSize / pageSize + 1;
        System.out.println(pageCount+"aaa");
        //计算开始截取的下标
        int currentIndex = (pageNum-1) * pageSize;
        //计算结束截取的下标
        int endIndex = pageNum==pageCount?dataSize:pageNum*pageSize;
        System.out.println(endIndex+"bbb");
        //开始截取数据
        //10  11
/*if (currentIndex!=0){
    if ()
}*/
            for (int i = currentIndex; i <endIndex; i++) {
                System.out.println(currentIndex);
                System.out.println(endIndex);
                data.add(list.get(i));
            }


        //是否第一页
        boolean isFirstPage = pageNum==1?true:false;
        //是否为最后一页
        boolean isLastPage = pageNum == pageCount?true:false;
        PageInfo pageInfo = new PageInfo(data,pageNum,isFirstPage,isLastPage,pageCount);
        return pageInfo;
    }
}
        /*jdbc.driver=com.mysql.cj.jdbc.Driver
        jdbc.url=jdbc:mysql://localhost:3306/sys_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL
        jdbc.username=root
        jdbc.password=root*/
