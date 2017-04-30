package com.huangshan.demo.bean;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Author(s): danyun
 * Date: 2017/4/30
 */
public class ImdbResult {
    private JSONArray search;
    private String totalResult;
    private String response;

    public static ImdbResult fill(JSONObject o) {
        ImdbResult imdbResult = new ImdbResult();
        if (o.has("Search")) {
            imdbResult.setSearch(o.optJSONArray("Search"));
        }
        if (o.has("TotalResult")) {
            imdbResult.setTotalResult("TotalResult");
        }
        if (o.has("Response")) {
            imdbResult.setResponse("Response");
        }
        return imdbResult;
    }

    public JSONArray getSearch() {
        return search;
    }

    public ImdbResult setSearch(JSONArray search) {
        this.search = search;
        return this;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public ImdbResult setTotalResult(String totalResult) {
        this.totalResult = totalResult;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public ImdbResult setResponse(String response) {
        this.response = response;
        return this;
    }
}
