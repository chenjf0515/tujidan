package com.tujidan.android.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class TopTableDb {
    private static List<TopTab> selected = new ArrayList<>();

    static {
        selected.add(new TopTab("推荐"));
        selected.add(new TopTab("视频"));
        selected.add(new TopTab("图片"));
        selected.add(new TopTab("段子"));
        selected.add(new TopTab("原创"));
        selected.add(new TopTab("网红"));
        selected.add(new TopTab("排行"));
        selected.add(new TopTab("社会"));
        selected.add(new TopTab("美女"));
        selected.add(new TopTab("冷知识"));
        selected.add(new TopTab("游戏"));
    }

    public static List<TopTab> getSelected() {
        return selected;
    }


}
