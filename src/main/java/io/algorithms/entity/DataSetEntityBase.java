package io.algorithms.entity;

import io.algorithms.datastore.DataStore;
import io.algorithms.datastore.DataStoreNotFoundException;
import io.algorithms.datastore.DataStoreRegister;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord(table="datasources")
@XmlRootElement
public class DataSetEntityBase implements DataSetEntity {
    
    private long size;

    @Column(name="location")
    private String location; 

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_seq")
    private Long id;

    @Column(name="friendly_name")
    private String name;

    @Column(name="friendly_description")
    private String description;

    @Column(name="filesystem_name")
    private String fileSystemName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetime_created")
    private Date createTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetime_modified")
    private Date lastModifiedTime;

    @ManyToOne
    @JoinColumn(name="customer_id_seq")
    private UserEntityBase owner;
    
    @Transient
    private DataStore dataStore;
    
    @Transient
    private String folder;
    
    @Override
    public Long getId() {
        return this.id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
        if (name == null && id != null) {
            name = String.valueOf(id);
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public Date getCreateTime() {
        return this.createTime;
    }
    
    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public Date getLastModifiedTime() {
        return this.lastModifiedTime;
    }
    
    @Override
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public UserEntity getOwner() {
        return owner;
    }
    
    @Override
    public void setOwner(UserEntityBase owner) {
        this.owner = owner;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#getSize()
     */
    @Override
    public long getSize() {
        return this.size;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#setSize(long)
     */
    @Override
    public void setSize(long size) {
        this.size = size;
    }


    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#getFileSystemName()
     */
    @Override
    public String getFileSystemName() {
        return fileSystemName;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#setFileSystemName(java.lang.String)
     */
    @Override
    public void setFileSystemName(String fileSystemName) {
        this.fileSystemName = fileSystemName;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#getDataFile()
     */
    @Override
    public File getDataFile() throws IOException {
        cacheDataStoreAndFolder();
        return dataStore.getFile(folder, fileSystemName);
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#putDataFile(java.io.File)
     */
    @Override
    public void putDataFile(File file) throws IOException {
        cacheDataStoreAndFolder();
        dataStore.putFile(folder, fileSystemName, file);
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#getDataInputStream()
     */
    @Override
    public InputStream getDataInputStream() throws IOException {
        cacheDataStoreAndFolder();
        return dataStore.getInputStream(folder, fileSystemName);
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#getDataOutputStream()
     */
    @Override
    public OutputStream getDataOutputStream() throws IOException {
        cacheDataStoreAndFolder();
        return dataStore.getOutputStream(folder, fileSystemName);
    }
    /**
     * This parses the location field which has the format "S3,bucketname"
     */
    private void cacheDataStoreAndFolder() throws IOException {
        if ((dataStore == null || folder == null) && location != null) {
            String[] dataSourceAndFolder = location.split(",");
            if (dataSourceAndFolder == null || dataSourceAndFolder.length != 2) {
                throw new IOException("Invalid location [" + location + "]. Must be of the form 'DataSource,Folder'");
            }
            folder = dataSourceAndFolder[1];
            String dataStoreString = dataSourceAndFolder[0];
            if (folder == null || dataStoreString == null) {
                throw new IOException("Invalid location [" + location + "]. Must be of the form 'DataSource,Folder'");
            }
            try {
                dataStore = DataStoreRegister.getDataStore(dataStoreString);
            } catch (DataStoreNotFoundException e) {
                throw new IOException("Cannot find dataStore with name [" + dataStoreString + "]", e);
            }
        }
    }
}
