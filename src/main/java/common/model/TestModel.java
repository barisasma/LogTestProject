package common.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestModel {

    private long id;
    private String code;
    private String name;
    private List<String> list = new ArrayList<String>();
    private Integer[] array = {1,2,3};

    public TestModel() {
    }

    public TestModel(long id) {
        this.id = id;
    }

    public TestModel(long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
        list.add("1");
        list.add("2");
        list.add("3");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestModel [id=");
        builder.append(id);
        builder.append(", code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", list=");
        builder.append(list);
        builder.append(", array=");
        builder.append(Arrays.toString(array));
        builder.append("]");
        return builder.toString();
    }

   

    
    
}
