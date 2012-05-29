// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.JobDataOnDemand;
import io.algorithms.entity.JobEntityBase;
import io.algorithms.entity.JobIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect JobIntegrationTest_Roo_IntegrationTest {
    
    declare @type: JobIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: JobIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: JobIntegrationTest: @Transactional;
    
    @Autowired
    private JobDataOnDemand JobIntegrationTest.dod;
    
    @Test
    public void JobIntegrationTest.testCountJobEntityBases() {
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", dod.getRandomJobEntityBase());
        long count = JobEntityBase.countJobEntityBases();
        Assert.assertTrue("Counter for 'JobEntityBase' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void JobIntegrationTest.testFindJobEntityBase() {
        JobEntityBase obj = dod.getRandomJobEntityBase();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to provide an identifier", id);
        obj = JobEntityBase.findJobEntityBase(id);
        Assert.assertNotNull("Find method for 'JobEntityBase' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'JobEntityBase' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void JobIntegrationTest.testFindAllJobEntityBases() {
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", dod.getRandomJobEntityBase());
        long count = JobEntityBase.countJobEntityBases();
        Assert.assertTrue("Too expensive to perform a find all test for 'JobEntityBase', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<JobEntityBase> result = JobEntityBase.findAllJobEntityBases();
        Assert.assertNotNull("Find all method for 'JobEntityBase' illegally returned null", result);
        Assert.assertTrue("Find all method for 'JobEntityBase' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void JobIntegrationTest.testFindJobEntityBaseEntries() {
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", dod.getRandomJobEntityBase());
        long count = JobEntityBase.countJobEntityBases();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<JobEntityBase> result = JobEntityBase.findJobEntityBaseEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'JobEntityBase' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'JobEntityBase' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void JobIntegrationTest.testFlush() {
        JobEntityBase obj = dod.getRandomJobEntityBase();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to provide an identifier", id);
        obj = JobEntityBase.findJobEntityBase(id);
        Assert.assertNotNull("Find method for 'JobEntityBase' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyJobEntityBase(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'JobEntityBase' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void JobIntegrationTest.testMergeUpdate() {
        JobEntityBase obj = dod.getRandomJobEntityBase();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to provide an identifier", id);
        obj = JobEntityBase.findJobEntityBase(id);
        boolean modified =  dod.modifyJobEntityBase(obj);
        Integer currentVersion = obj.getVersion();
        JobEntityBase merged = (JobEntityBase)obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'JobEntityBase' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void JobIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", dod.getRandomJobEntityBase());
        JobEntityBase obj = dod.getNewTransientJobEntityBase(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'JobEntityBase' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'JobEntityBase' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void JobIntegrationTest.testRemove() {
        JobEntityBase obj = dod.getRandomJobEntityBase();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'JobEntityBase' failed to provide an identifier", id);
        obj = JobEntityBase.findJobEntityBase(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'JobEntityBase' with identifier '" + id + "'", JobEntityBase.findJobEntityBase(id));
    }
    
}
