package com.beautiful.api.metadata;
import com.beautiful.api.schema.ColumnType;
import java.util.List;
import java.util.Set;

public class StructMetaData extends BaseColumnMetaData{

    List<ColumnMetaData> beanmetas;
    private Set<String> names;
    public StructMetaData(String name,List<ColumnMetaData> pairs){
        super(name);
        this.beanmetas=pairs;
        for (ColumnMetaData metaData:
             beanmetas) {
            names.add(metaData.getName());
        }
    }



    public StructMetaData add(ColumnMetaData columnMetaData){
        String name=columnMetaData.getName();
        if(!names.contains(name)) this.beanmetas.add(columnMetaData);
        return this;
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.STRUCT;
    }

    @Override
    public ColumnMetaData clone() {
        return new StructMetaData(name,beanmetas);
    }

    public List<ColumnMetaData> getBeanmetas() {
        return beanmetas;
    }

    public void setBeanmetas(List<ColumnMetaData> beanmetas) {
        this.beanmetas = beanmetas;
    }

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "StructMetaData{" + "beanmetas=" + beanmetas + ", names=" + names + ", name='" + name + '\'' + '}';
    }
}
