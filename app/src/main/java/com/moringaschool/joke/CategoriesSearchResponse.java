
package com.moringaschool.joke;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CategoriesSearchResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("categoryAliases")
    @Expose
    private List<CategoryAlias> categoryAliases = null;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CategoriesSearchResponse() {
    }

    /**
     * 
     * @param categoryAliases
     * @param categories
     * @param error
     * @param timestamp
     */
    public CategoriesSearchResponse(Boolean error, List<String> categories, List<CategoryAlias> categoryAliases, Long timestamp) {
        super();
        this.error = error;
        this.categories = categories;
        this.categoryAliases = categoryAliases;
        this.timestamp = timestamp;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<CategoryAlias> getCategoryAliases() {
        return categoryAliases;
    }

    public void setCategoryAliases(List<CategoryAlias> categoryAliases) {
        this.categoryAliases = categoryAliases;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
