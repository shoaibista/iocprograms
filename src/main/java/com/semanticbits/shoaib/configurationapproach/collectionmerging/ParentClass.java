package com.semanticbits.shoaib.configurationapproach.collectionmerging;

import java.util.List;
import java.util.Map;

/**
 * Created by shoaib on 2/3/14.
 */
public class ParentClass {

    private List<String> subjects;
    private Map information;

    public Map getInformation() {
        return information;
    }

    public void setInformation(Map information) {
        this.information = information;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
