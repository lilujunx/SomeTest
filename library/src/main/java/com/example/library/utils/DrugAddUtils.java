package com.zihehealth.zihehealth.ZiheHealth.utils;

import com.zihehealth.zihehealth.ZiheHealth.entity.LvDrugAddEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/4.
 */

public class DrugAddUtils {
    public static List<LvDrugAddEntity> getEntity(int[] pics, String[] titles, String[] adds){
        List<LvDrugAddEntity> entities=new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            LvDrugAddEntity entity=new LvDrugAddEntity();
            entity.setAdd(adds[i]);
            entity.setPic(pics[i]);
            entity.setTitle(titles[i]);
            entities.add(entity);
        }
        return entities;
    }
}
