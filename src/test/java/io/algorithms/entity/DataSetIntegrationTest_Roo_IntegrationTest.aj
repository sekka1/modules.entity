// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.DataSetEntity;
import io.algorithms.entity.DataSetDataOnDemand;
import io.algorithms.entity.DataSetIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DataSetIntegrationTest_Roo_IntegrationTest {
    
    declare @type: DataSetIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: DataSetIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: DataSetIntegrationTest: @Transactional;
    
    @Autowired
    private DataSetDataOnDemand DataSetIntegrationTest.dod;
    
    @Test
    public void DataSetIntegrationTest.testCountDataSets() {
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", dod.getRandomDataSet());
        long count = DataSetEntity.countDataSetEntitys();
        Assert.assertTrue("Counter for 'DataSet' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void DataSetIntegrationTest.testFindDataSet() {
        DataSetEntity obj = dod.getRandomDataSet();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to provide an identifier", id);
        obj = DataSetEntity.findDataSetEntity(id);
        Assert.assertNotNull("Find method for 'DataSet' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'DataSet' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void DataSetIntegrationTest.testFindAllDataSets() {
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", dod.getRandomDataSet());
        long count = DataSetEntity.countDataSetEntitys();
        Assert.assertTrue("Too expensive to perform a find all test for 'DataSet', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<DataSetEntity> result = DataSetEntity.findAllDataSetEntitys();
        Assert.assertNotNull("Find all method for 'DataSet' illegally returned null", result);
        Assert.assertTrue("Find all method for 'DataSet' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void DataSetIntegrationTest.testFindDataSetEntries() {
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", dod.getRandomDataSet());
        long count = DataSetEntity.countDataSetEntitys();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<DataSetEntity> result = DataSetEntity.findDataSetEntityEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'DataSet' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'DataSet' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void DataSetIntegrationTest.testFlush() {
        DataSetEntity obj = dod.getRandomDataSet();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to provide an identifier", id);
        obj = DataSetEntity.findDataSetEntity(id);
        Assert.assertNotNull("Find method for 'DataSet' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyDataSet(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'DataSet' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void DataSetIntegrationTest.testMergeUpdate() {
        DataSetEntity obj = dod.getRandomDataSet();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to provide an identifier", id);
        obj = DataSetEntity.findDataSetEntity(id);
        boolean modified =  dod.modifyDataSet(obj);
        Integer currentVersion = obj.getVersion();
        DataSetEntity merged = (DataSetEntity)obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'DataSet' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void DataSetIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", dod.getRandomDataSet());
        DataSetEntity obj = dod.getNewTransientDataSet(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'DataSet' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'DataSet' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'DataSet' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void DataSetIntegrationTest.testRemove() {
        DataSetEntity obj = dod.getRandomDataSet();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DataSet' failed to provide an identifier", id);
        obj = DataSetEntity.findDataSetEntity(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'DataSet' with identifier '" + id + "'", DataSetEntity.findDataSetEntity(id));
    }
    
}
