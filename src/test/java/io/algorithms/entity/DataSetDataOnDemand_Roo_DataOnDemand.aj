// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.DataSetDataOnDemand;
import io.algorithms.entity.DataSetEntityBase;
import io.algorithms.entity.UserEntityBase;
import io.algorithms.entity.UserEntityBaseDataOnDemand;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect DataSetDataOnDemand_Roo_DataOnDemand {
    
    declare @type: DataSetDataOnDemand: @Component;
    
    private Random DataSetDataOnDemand.rnd = new SecureRandom();
    
    private List<DataSetEntityBase> DataSetDataOnDemand.data;
    
    @Autowired
    private UserEntityBaseDataOnDemand DataSetDataOnDemand.userEntityBaseDataOnDemand;
    
    public DataSetEntityBase DataSetDataOnDemand.getNewTransientDataSetEntityBase(int index) {
        DataSetEntityBase obj = new DataSetEntityBase();
        setCreateTime(obj, index);
        setDescription(obj, index);
        setLastModifiedTime(obj, index);
        setName(obj, index);
        setOwner(obj, index);
        setSize(obj, index);
        return obj;
    }
    
    public void DataSetDataOnDemand.setCreateTime(DataSetEntityBase obj, int index) {
        Date createTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setCreateTime(createTime);
    }
    
    public void DataSetDataOnDemand.setDescription(DataSetEntityBase obj, int index) {
        String description = "description_" + index;
        obj.setDescription(description);
    }
    
    public void DataSetDataOnDemand.setLastModifiedTime(DataSetEntityBase obj, int index) {
        Date lastModifiedTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setLastModifiedTime(lastModifiedTime);
    }
    
    public void DataSetDataOnDemand.setName(DataSetEntityBase obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    public void DataSetDataOnDemand.setOwner(DataSetEntityBase obj, int index) {
        UserEntityBase owner = userEntityBaseDataOnDemand.getRandomUserEntityBase();
        obj.setOwner(owner);
    }
    
    public void DataSetDataOnDemand.setSize(DataSetEntityBase obj, int index) {
        Long size = new Integer(index).longValue();
        obj.setSize(size);
    }
    
    public DataSetEntityBase DataSetDataOnDemand.getSpecificDataSetEntityBase(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        DataSetEntityBase obj = data.get(index);
        Long id = obj.getId();
        return DataSetEntityBase.findDataSetEntityBase(id);
    }
    
    public DataSetEntityBase DataSetDataOnDemand.getRandomDataSetEntityBase() {
        init();
        DataSetEntityBase obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return DataSetEntityBase.findDataSetEntityBase(id);
    }
    
    public boolean DataSetDataOnDemand.modifyDataSetEntityBase(DataSetEntityBase obj) {
        return false;
    }
    
    public void DataSetDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = DataSetEntityBase.findDataSetEntityBaseEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'DataSetEntityBase' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<DataSetEntityBase>();
        for (int i = 0; i < 10; i++) {
            DataSetEntityBase obj = getNewTransientDataSetEntityBase(i);
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