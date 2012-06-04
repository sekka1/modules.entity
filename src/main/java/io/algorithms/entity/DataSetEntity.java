package io.algorithms.entity;

import io.algorithms.datastore.DataStore;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@XmlRootElement
public class DataSetEntity extends Entity {
    
    private long size;

    @Enumerated(EnumType.STRING)
    private DataFormat format;

    @ElementCollection(targetClass=FieldEntity.class)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<FieldEntity> fields;

    @XmlTransient
    @Transient
    private DataStore fileStore;
    
    public InputStream getDataStream() throws IOException {
        return fileStore.getStream(getId().toString(), getId().toString());
    }
    
    public File getDataFile() throws IOException {
        return fileStore.getFile(getId().toString(), getId().toString());
    }
    
    public void putDataStream(InputStream inputStream) throws IOException {
        fileStore.putStream(getId().toString(), getId().toString(), inputStream);
    }
    
    public void putDataFile(File file) throws IOException {
        fileStore.putFile(getId().toString(), getId().toString(), file);
    }
}
