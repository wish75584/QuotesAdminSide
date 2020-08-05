package com.stubborn.quotesadminside.Modal;

public class QuotesModal {
    String id, c_id, c_cat_id, c_cat, c_quotes, c_author, c_desc;

    public QuotesModal() {
    }

    public QuotesModal(String id, String c_id, String c_cat_id, String c_cat, String c_quotes, String c_author, String c_desc) {
        this.id = id;
        this.c_id = c_id;
        this.c_cat_id = c_cat_id;
        this.c_cat = c_cat;
        this.c_quotes = c_quotes;
        this.c_author = c_author;
        this.c_desc = c_desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_cat_id() {
        return c_cat_id;
    }

    public void setC_cat_id(String c_cat_id) {
        this.c_cat_id = c_cat_id;
    }

    public String getC_cat() {
        return c_cat;
    }

    public void setC_cat(String c_cat) {
        this.c_cat = c_cat;
    }

    public String getC_quotes() {
        return c_quotes;
    }

    public void setC_quotes(String c_quotes) {
        this.c_quotes = c_quotes;
    }

    public String getC_author() {
        return c_author;
    }

    public void setC_author(String c_author) {
        this.c_author = c_author;
    }

    public String getC_desc() {
        return c_desc;
    }

    public void setC_desc(String c_desc) {
        this.c_desc = c_desc;
    }
}