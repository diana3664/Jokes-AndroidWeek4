
package com.moringaschool.joke;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryAlias {

    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("resolved")
    @Expose
    private String resolved;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CategoryAlias() {
    }

    /**
     * 
     * @param alias
     * @param resolved
     */
    public CategoryAlias(String alias, String resolved) {
        super();
        this.alias = alias;
        this.resolved = resolved;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

}
