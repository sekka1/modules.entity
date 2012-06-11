// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.AlgorithmDataOnDemand;
import io.algorithms.entity.AlgorithmEntityBase;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect AlgorithmDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AlgorithmDataOnDemand: @Component;
    
    private Random AlgorithmDataOnDemand.rnd = new SecureRandom();
    
    private List<AlgorithmEntityBase> AlgorithmDataOnDemand.data;
    
    public AlgorithmEntityBase AlgorithmDataOnDemand.getNewTransientAlgorithmEntityBase(int index) {
        AlgorithmEntityBase obj = new AlgorithmEntityBase();
        setCategory(obj, index);
        setCreateTime(obj, index);
        setDescription(obj, index);
        setLastModifiedTime(obj, index);
        setName(obj, index);
        return obj;
    }
    
    public void AlgorithmDataOnDemand.setCategory(AlgorithmEntityBase obj, int index) {
        String category = "category_" + index;
        obj.setCategory(category);
    }
    
    public void AlgorithmDataOnDemand.setCreateTime(AlgorithmEntityBase obj, int index) {
        Date createTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setCreateTime(createTime);
    }
    
    public void AlgorithmDataOnDemand.setDescription(AlgorithmEntityBase obj, int index) {
        String description = "description_" + index;
        obj.setDescription(description);
    }
    
    public void AlgorithmDataOnDemand.setLastModifiedTime(AlgorithmEntityBase obj, int index) {
        Date lastModifiedTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setLastModifiedTime(lastModifiedTime);
    }
    
    public void AlgorithmDataOnDemand.setName(AlgorithmEntityBase obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    public AlgorithmEntityBase AlgorithmDataOnDemand.getSpecificAlgorithmEntityBase(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        AlgorithmEntityBase obj = data.get(index);
        Long id = obj.getId();
        return AlgorithmEntityBase.findAlgorithmEntityBase(id);
    }
    
    public AlgorithmEntityBase AlgorithmDataOnDemand.getRandomAlgorithmEntityBase() {
        init();
        AlgorithmEntityBase obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return AlgorithmEntityBase.findAlgorithmEntityBase(id);
    }
    
    public boolean AlgorithmDataOnDemand.modifyAlgorithmEntityBase(AlgorithmEntityBase obj) {
        return false;
    }
    
    public void AlgorithmDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = AlgorithmEntityBase.findAlgorithmEntityBaseEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'AlgorithmEntityBase' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<AlgorithmEntityBase>();
        for (int i = 0; i < 10; i++) {
            AlgorithmEntityBase obj = getNewTransientAlgorithmEntityBase(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
