package com.gooddoctor.data.gson;

import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-11.
 */
public class DiseaseCategory {
    private String title;
    private List<Disease> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Disease> getContent() {
        return content;
    }

    public void setContent(List<Disease> content) {
        this.content = content;
    }
}
